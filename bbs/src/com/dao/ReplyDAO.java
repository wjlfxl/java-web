package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.entity.Reply;
//import com.bbs.entity.Topic;

public class ReplyDAO extends BaseDAO{
	public Connection conn=null;
	public Statement stmt=null;
	public PreparedStatement pstmt=null;
	public ResultSet rs=null;
	
	public int findCountReply(int topicId)
	{
		int count=0;
		String sql="select count(*) from reply where topicId="+topicId;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 
			 this.closeAll(conn, pstmt, rs);
		 }
		
		return count;
	}
	public  List   findListReply(int  page,int   topicId){
		List  list=new  ArrayList();
		int rowBegin = 0; // ��ʼ��������ʾÿҳ��һ����¼�����ݿ��е�����
		if (page > 1) {	// ��ҳ��ȡ�ÿ�ʼ��������ÿҳ������ʾ10���ظ�
	    rowBegin = 3* (page - 1); }
	    String sql2 = "select  * from reply where topicId=" + topicId + " limit "+rowBegin+",3";//"select  * from topic where channelId=" + channelId +" and topicId not in(select top " + rowBegin + " topicId from topic where channelId=" + channelId + " order by publishTime desc )order by publishTimedesc";
        Reply  reply=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				reply=new  Reply();
				reply.setReplyId(rs.getInt(1));
				reply.setTitle(rs.getString(2));
				reply.setContent(rs.getString(3));
				reply.setPublishTime(rs.getString(4));
				reply.setModifyTime(rs.getString(5));
				reply.setUserId(rs.getInt(6));
				reply.setTopicId(rs.getInt(7));
				list.add(reply);
			}
		
		}catch(SQLException   e){
			e.printStackTrace();
		}
			finally{
				this.closeAll(conn,pstmt,rs);
		}
			return   list;
	}	
	/**
	*�������лظ�
	*@paramtopicId
	*@return��ѯ���
	*/
	public List findListReply() {
	        List list  = new ArrayList();  
            conn=null;
            pstmt=null;
            rs=null;
            Reply  reply=null;
            try{
            	conn=this.getConn();
            	String   sql="select * from reply";
            	pstmt=conn.prepareStatement(sql);
    			rs=pstmt.executeQuery();
    			while(rs.next())
    			{
    				reply=new  Reply();
    				reply.setReplyId(rs.getInt(1));
    				reply.setTitle(rs.getString(2));
    				reply.setContent(rs.getString(3));
    				reply.setPublishTime(rs.getString(4));
    				reply.setModifyTime(rs.getString(5));
    				reply.setUserId(rs.getInt(6));
    				reply.setTopicId(rs.getInt(7));
    				list.add(reply);
    			}
    		
    		}catch(SQLException   e){
    			e.printStackTrace();
    		}
    			finally{
    				this.closeAll(conn,pstmt,rs);
    		}
    			return   list;
    	}	
	/**
     * ��ӻظ�
     * @param reply
     * @return ��������
     */
public int addReply(Reply reply) {
	List list  = new ArrayList(); 
	list=findListReply();
	Reply  re=(Reply)list.get(list.size()-1);
	int replyId=re.getReplyId()+1;
	String   sql  = "insert into reply values("+replyId+",?,?,?,?," + reply.getUserId() + "," + reply.getTopicId() + ")";//�߸��ֶ�
    String   time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ȡ������ʱ��
	String[] parm = { reply.getTitle(), reply.getContent(), time, time };
	return this.executeSQL(sql, parm);// ִ��sql��������Ӱ������
   }
/**
 * ���»ظ�
 * @param reply
 * @return ��������
 */
public int updateReply(Reply reply) {
    String   sql  = "update reply set title=?, content=?, modifyTime=? where replyId="+reply.getReplyId();
    String   time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // ȡ������ʱ��
    String[] parm = { reply.getTitle(), reply.getContent(), time };
    return this.executeSQL(sql, parm); // ִ��sql��������Ӱ������
}
public Reply findReply(int  replyId) { 
    conn=null;
    pstmt=null;
    rs=null;
    Reply  reply=null;
    try{
    	conn=this.getConn();
    	String   sql="select * from reply";
    	pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			reply=new  Reply();
			reply.setReplyId(rs.getInt(1));
			reply.setTitle(rs.getString(2));
			reply.setContent(rs.getString(3));
			reply.setPublishTime(rs.getString(4));
			reply.setModifyTime(rs.getString(5));
			reply.setUserId(rs.getInt(6));
			reply.setTopicId(rs.getInt(7));
			
		}
	
	}catch(SQLException   e){
		e.printStackTrace();
	}
		finally{
			this.closeAll(conn,pstmt,rs);
	}
		return   reply;
}	
/**
 * ɾ���ظ�
 * @param reply
 * @return ��������
 */
public int deleteReply(Reply reply) {
    String   sql  = "delete reply set title=?, content=?, modifyTime=? where replyId="+reply.getReplyId();
    String   time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // ȡ������ʱ��
    String[] parm = { reply.getTitle(), reply.getContent(), time };
    return this.executeSQL(sql, parm); // ִ��sql��������Ӱ������
}

}
