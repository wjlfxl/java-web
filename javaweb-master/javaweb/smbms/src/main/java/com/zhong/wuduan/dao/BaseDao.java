package com.zhong.wuduan.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/20 20:12
 */
//操作数据库的公共类
public class BaseDao {
private static String driver;
private static String url;
private static String username;
private static String password;

//静态代码块，类加载的时候即初始化
    static {
    Properties properties = new Properties();
    //通过类加载器读取对应的资源
    InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

    try {
        properties.load(is);


    } catch (IOException e) {
        e.printStackTrace();
    }
     driver = properties.getProperty("driver");
    url=properties.getProperty("url");
    username=properties.getProperty("username");
    password=properties.getProperty("password");

    //获取数据库的连接


}
    public static   Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
           connection= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
return  connection;
    }
    //编写查询公共类
    public  static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        //预编译的SQL
         preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject占位符从1开始，但是数组是从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
         resultSet = preparedStatement.executeQuery();

        return  resultSet;
    }
    //编写CURD
    //更新
    public  static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject占位符从1开始，但是数组是从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
        int i = preparedStatement.executeUpdate();

        return i;
    }

    //释放资源
    public static boolean closeResource(Connection connection,ResultSet resultSet,PreparedStatement preparedStatement){
        boolean flag=true;
        if(resultSet!=null){
            try {
                resultSet.close();
                //GC回收
                resultSet=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(connection!=null){
            try {
                connection.close();
                //GC回收
                connection=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
                //GC回收
                preparedStatement=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }
}
