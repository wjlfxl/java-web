package com.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.entity.Channel;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ChannelDAO   extends  BaseDAO {
	public  Connection conn=null;
	public  Statement stmt=null;
	public  PreparedStatement   pstmt=null;
	public  ResultSet rs=null;
	public  List   findChanneList(){
		List  list=new  ArrayList();
		String    sql="select  *  from  channel"; 
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Channel    channel=new  Channel();
				channel.setChannelId(rs.getInt(1));
				channel.setChannelName(rs.getString(2));
				channel.setUserId(rs.getInt(3));
				list.add(channel);
			}
			   
		}catch(SQLException   e){
			e.printStackTrace();
		}
			finally{
				this.closeAll(conn,pstmt,rs);
		}
			return   list;
	  }
	
	public Channel getChannel(int    channelId) {
		String sql = "select * from channel where channelId=" + channelId; 
		Channel channel = null; // ����һ���յ�Ƶ������
		try {
			conn= this.getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��sqlȡ�ý����
			if (rs.next()) {
				channel = new Channel(); // ʵ����Ƶ������
				channel.setChannelId(rs.getInt(1)); // Ƶ��id
				channel.setChannelName(rs.getString(2)); // Ƶ������
				channel.setUserId(rs.getInt(3));         // ����
			}
		} catch (Exception e) {
			e.printStackTrace(); // �����쳣
		} finally {
			this.closeResultSet(rs); // �ͷ���Դ
			this.closePreparedStatement(pstmt);
			this.closeConnection(conn);
		}
		return channel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}