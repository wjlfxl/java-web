package com.zhong.wuduan.mail;
import com.sun.mail.util.MailSSLSocketFactory;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/3/1 15:51
 */
public class easyMail {
    //简单邮件：没有附件和图片，纯文本

    //要发送邮件，需要获得协议和支持，开启POP3/SMTP协议
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");//设置QQ邮件服务器
        properties.setProperty("mail.transport.protocol","smtp");;//邮件发送协议
        properties.setProperty("mail.smtp.auth","true");//需要验证用户名和密码

        //如果是QQ邮箱，还需设置如下
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","false");
        properties.put("mail.smtp.ssl.socketFactory",sf);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需要的环境信息的Session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            //这个session只有QQ邮箱才有
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发送人的邮件用户名，授权码
                return new PasswordAuthentication("2412025035@qq.com", "bdwrekjyacdldjae");
            }
        });
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过Session得到transport对象
        Transport transport = session.getTransport();
        //3.使用邮箱的用户名和授权码连接上服务器
        transport.connect("smtp.qq.com","2412025035@qq.com","bdwrekjyacdldjae");
        //4.创建邮件
        //注意需要传递Session
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("2412025035@qq.com"));//指明发件人
        message.setSubject("只包含文本的简单邮件");//邮件主题
        //邮件内容
        //收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("2412025035@qq.com"));
        //邮件的文本内容
        message.setContent("2022/3/1,你好","text/html;charset=UTF-8");
        //5.发送邮件
        transport.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        transport.close();
    }
}
