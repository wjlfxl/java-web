package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import  com.entity.*;
//import com.sun.org.apache.bcel.internal.generic.NEW;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class UserDao extends BaseDAO {
	public  Connection conn=null;
	public  Statement stmt=null;
	public  PreparedStatement   pstmt=null;
	public  ResultSet rs=null;
	public  User  findUser(int    uId){
		User   user=null;
		String   sql="select*from  user   where   userId="+uId;
		try{
		conn=this.getConn();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			user=new  User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setHead(rs.getString(4));
			user.setRegisterTime(rs.getString(5));
			user.setRole(rs.getInt(6));
		}
		   
	}catch(SQLException   e){
		e.printStackTrace();
	}
		finally{
			this.closeAll(conn,pstmt,rs);
	}
		return   user;
  }
	public  User  findUser(String  uName){
		User   user=null;
		//String   sql="select*from  user   where   userName='"+uName+"'";
		String   sql2="select  *from   user  where   userName=?";
		try{
		conn=this.getConn();
		pstmt=conn.prepareStatement(sql2);
		pstmt.setString(1,uName);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			user=new  User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setHead(rs.getString(4));
			user.setRegisterTime(rs.getString(5));
			user.setRole(rs.getInt(6));
		}
		   
	}catch(SQLException   e){
		e.printStackTrace();
	}
		finally{
			this.closeAll(conn,pstmt,rs);
	}
		return   user;
  }
	public  List  findUser(){
		List   userList=new  ArrayList();
		User   user=null;
		//String   sql="select*from  user   where   userName='"+uName+"'";
		String   sql2="select  *from   user";
		try{
		conn=this.getConn();
		pstmt=conn.prepareStatement(sql2);
		//pstmt.setString(1,uName);
		rs=pstmt.executeQuery();
		//if(rs.next())
		while(rs.next())
		{
			user=new  User();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setHead(rs.getString(4));
			user.setRegisterTime(rs.getString(5));
			user.setRole(rs.getInt(6));
			userList.add(user);
		}
		   
	}catch(SQLException   e){
		e.printStackTrace();
	}
		finally{
			this.closeAll(conn,pstmt,rs);
	}
		return   userList;
  }
	public    int   addUser(User   user){
		int   id;
		List  uList=this.findUser();
	    User  u=(User)uList.get(uList.size()-1);
	    id=u.getUserId()+1;
		String   sql="insert   into    user  values("+id+",?,?,?,?,3)";
		String  time=new   SimpleDateFormat("yyyy-MM-dd   HH:mm:ss").format(new  Date());
		String[]   parm={user.getUserName(),user.getPassword(),user.getHead(),time};
		return   this.executeSQL(sql, parm);
	}
	public   int  updateUserRole(User  user){
		  String  sql="update   user   set  role="+user.getRole()+" where  userId="+user.getUserId();
		  return  this.executeSQL(sql, null);
	}
	public  boolean   isChannelMaster(int   userId){
		boolean   flag=false;
		String   sql="select*from  channel   where   userId"+userId;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}catch(SQLException   e){
			e.printStackTrace();
		}
			finally{
				this.closeAll(conn,pstmt,rs);
		}
		return  flag;
	}
	public    static  void    main(String[]   args){
		UserDao    uDao=new    UserDao();
		User   u=new  User();
		u.setUserName("yyy");u.setPassword("111111");u.setHead("head15.jpg");
		uDao.addUser(u);
	}
	
}
