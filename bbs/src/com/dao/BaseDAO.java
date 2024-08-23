package com.dao;

import java.sql.*;

public class BaseDAO {
	public final static String DRIVER_MYSQL_CLASS="com.mysql.jdbc.Driver";
	public final static String url="jdbc:mysql://127.0.0.1:3306/bbs?" +
		"useUnicode=true&amp;characterEncoding=utf-8&amp;" +
		"zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true";
	public Connection getConn(){
		Connection conn=null;
		try{
		     	Class.forName(DRIVER_MYSQL_CLASS);
		        conn=DriverManager.getConnection(url,"root","123456");
		   }
		catch(ClassNotFoundException e){e.printStackTrace();}
	    catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		return conn;
	}
	// �ر�����
		public void closeConnection(Connection connection) {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// �ر�PreparedStatement
		public void closePreparedStatement(PreparedStatement   pstmt) {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// �ر�ResultSet
		public void closeResultSet(ResultSet   rs) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public void closeAll(Connection conn,PreparedStatement  pstmt,ResultSet   rs){
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("rs");
					e.printStackTrace();
				}
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("pstmt");
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("conn");
					e.printStackTrace();
				}
			}
		}
	public    int    executeSQL(String   presql,String[]   param){
		int   num=0;
		Connection conn=null;
		PreparedStatement   pstmt=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(presql);
			if(param!=null)
			{
				for(int   i=0;i<param.length;i++)
					pstmt.setString(i+1,param[i]);
			}
			num=pstmt.executeUpdate();
		}catch(SQLException  e){
			e.printStackTrace();
		}
		finally{
			this.closePreparedStatement(pstmt);
			this.closeConnection(conn);
		}
		return   num;
	}
		
	

	public static void main(String[] args) {
		BaseDAO dao=new BaseDAO();
		Connection connection =null;
		Statement stmt=null;
		ResultSet rs=null;
        try{
        	connection =dao.getConn();
        	stmt=connection .createStatement();
            rs=stmt.executeQuery("select * from user");
            while(rs.next())
            {
            	System.out.println(rs.getString(2)+","+rs.getInt("role"));
            	
            }
            rs.close();stmt.close();connection.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}

}

