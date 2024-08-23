package com.zhong.wuduan.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/15 0:41
 */
//统计网站在线人数： 即统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建Session监听
    //一旦创建Session就会触发这个时间
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer onlineCount = (Integer) sc.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }

        sc.setAttribute("OnlineCount",onlineCount);
    }
    //销毁Session监听
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
