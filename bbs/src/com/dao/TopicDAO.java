package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//import  com.bbs.entity.*;
import com.entity.Reply;
import com.entity.Topic;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
public class TopicDAO extends BaseDAO {
	public  Connection conn=null;
	public  Statement stmt=null;
	public  PreparedStatement   pstmt=null;
	public  ResultSet rs=null;
	public  List   findListTopic(int  page,int channelId){
		List  list=new  ArrayList();
		int rowBegin = 0; // ��ʼ��������ʾÿҳ��һ����¼�����ݿ��е�����
		if (page > 1) {	// ��ҳ��ȡ�ÿ�ʼ��������ÿҳ������ʾ10���ظ�
	    rowBegin = 10* (page - 1); }
	    String sql2 = "select  * from topic where channelId=" + channelId + " limit "+rowBegin+",10";//"select  * from topic where channelId=" + channelId +" and topicId not in(select top " + rowBegin + " topicId from topic where channelId=" + channelId + " order by publishTime desc )order by publishTimedesc";
         Topic topic=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				topic=new  Topic();
				topic.setTopicId(rs.getInt(1));
				topic.setTitle(rs.getString(2));
				topic.setContent(rs.getString(3));
				topic.setPublishTime(rs.getString(4));
				topic.setModifyTime(rs.getString(5));
				topic.setUserId(rs.getInt(6));
				topic.setChannelId(rs.getInt(7));
				list.add(topic);
			}
			   
		}catch(SQLException   e){
			e.printStackTrace();
		}
			finally{
				this.closeAll(conn,pstmt,rs);
		}
			return   list;
	}	
	public Topic    findTopic(int topicId)
	{
		
		Topic topic=null;
	    String sql2="select * from topic where topicId="+topicId;
		 try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			 if(rs.next())
			 {   topic=new Topic();
			     topic.setTopicId(rs.getInt(1));
				 topic.setTitle(rs.getString(2));
				 topic.setContent(rs.getString(3));
				 topic.setPublishTime(rs.getString(4));
				 topic.setModifyTime(rs.getString(5));
				 topic.setUserId(rs.getInt(6));
				 topic.setChannelId(rs.getInt(7));
				
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 
			 this.closeAll(conn, pstmt, rs);
		 }
		 return topic;
	}
	/**
	 * ���ݰ��ID���Ҹð���������������topic
	 * @param channelId
	 * @return topicList
	 */
	public List findListTopic(int channelId)
	{
		List topicList=new ArrayList();
		Topic topic=null;
	    String sql2="select * from topic where channelId="+channelId;
		 try {
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			 while(rs.next())
			 {   topic=new Topic();
			     topic.setTopicId(rs.getInt(1));
				 topic.setTitle(rs.getString(2));
				 topic.setContent(rs.getString(3));
				 topic.setPublishTime(rs.getString(4));
				 topic.setModifyTime(rs.getString(5));
				 topic.setUserId(rs.getInt(6));
				 topic.setChannelId(rs.getInt(7));
				 topicList.add(topic);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 
			 this.closeAll(conn, pstmt, rs);
		 }
		 return topicList;
	}
	public  int   findCountTopic(int  channelId){
		int  count=0;
		String   sql="select  count(*)  from topic   where  channelId="+ channelId;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				 count=rs.getInt(1);
			}
		}catch(SQLException   e){
			e.printStackTrace();
		}
			finally{
				this.closeAll(conn,pstmt,rs);
		}
			return   count;
	}	
	public List findListTopic() {
        List list  = new ArrayList();  
        conn=null;
        pstmt=null;
        rs=null;
        Topic  topic=null;
        try{
        	conn=this.getConn();
        	String   sql="select * from topic";
        	pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				 topic=new Topic();
			     topic.setTopicId(rs.getInt(1));
				 topic.setTitle(rs.getString(2));
				 topic.setContent(rs.getString(3));
				 topic.setPublishTime(rs.getString(4));
				 topic.setModifyTime(rs.getString(5));
				 topic.setUserId(rs.getInt(6));
				 topic.setChannelId(rs.getInt(7));
				 list.add(topic);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 
			 this.closeAll(conn, pstmt, rs);
		 }
		 return list;
	}
			
	public int addTopic(Topic  topic) {
		List list  = new ArrayList(); 
		list=findListTopic();
		Topic to=(Topic)list.get(list.size()-1);
		int topicId=to.getTopicId()+1;
	    String sql = "insert into topic values("+topicId+",?,?,?,?," + topic.getUserId() + "," + topic.getChannelId() + ")";
	    String   time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ȡ������ʱ��
		String[] parm = { topic.getTitle(), topic.getContent(), time, time };
		return this.executeSQL(sql, parm);// ִ��sql��������Ӱ������
	}
	/**
	 * ��������
	 * @param topic
	 * @return ��������
	 */
	public int updateTopic(Topic topic) {
		String sql = "update topic set title=?, content=?, modifyTime=? where topicId=" + topic.getTopicId();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // ȡ������ʱ��
		String[] parm = { topic.getTitle(), topic.getContent(), time };
				return this.executeSQL(sql, parm); // ִ��sql��������Ӱ������
   }

	
}



