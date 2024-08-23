package com.plasticine.dao;

import com.mysql.cj.protocol.Resultset;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 公共的操作数据库类
 */
public class BaseDao {

    private static String Driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块 -- 类加载的时候就会初始化静态代码块中的代码
    static {
        // 读取数据库配置 properties 文件
        Properties properties = new Properties();
        // 把配置文件读入到流
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        // 加载输入流到 properties 对象中 -- 可能发生 IO 读取异常，所以要捕获
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 初始化数据库连接信息
        Driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    /**
     * 获取数据库连接
     *
     * @return Connection对象
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // 驱动加载失败
            e.printStackTrace();
            System.out.println("驱动未加载成功，请检查properties配置文件中的driver属性是否正确");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

    /**
     * 封装通用的查询方法
     *
     * @param connection 数据库连接对象
     * @param sql        要执行的查询 SQL 语句
     * @param params     SQL语句的参数
     * @param resultSet  查询执行的结果集
     * @return 返回执行的结果集
     * @throws SQLException SQL参数赋值以及SQL语句执行可能出错，出错时会抛出异常
     */
    public static Resultset execute(Connection connection, String sql, Object[] params, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        // 使用预编译的 SQL 方式执行查询
        preparedStatement = connection.prepareStatement(sql);

        // 给 SQL 的参数赋值
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }

        resultSet = preparedStatement.executeQuery();

        return (Resultset) resultSet;
    }

    /**
     * 封装通用的增改查方法
     *
     * @param connection 数据库连接对象
     * @param sql        要执行的查询 SQL 语句
     * @param params     SQL语句的参数
     * @return 返回受影响的行数
     * @throws SQLException SQL参数赋值以及SQL语句执行可能出错，出错时会抛出异常
     */
    public static int execute(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement) throws SQLException {
        // 使用预编译的 SQL 方式执行查询
        preparedStatement = connection.prepareStatement(sql);

        // 给 SQL 的参数赋值
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }

        return preparedStatement.executeUpdate();
    }

    /**
     * 释放连接资源
     *
     * @param connection        数据库连接对象
     * @param resultSet         查询的结果集
     * @param preparedStatement 预编译 Statement 对象
     * @return 释放成功返回 true
     */
    public static boolean closeResource(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
        boolean flag = true;

        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }

}
