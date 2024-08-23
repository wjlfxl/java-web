package com.example.mailspring;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class MailSpringApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //发送邮件
        //收件人
        //内容

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Spring");
        message.setText("Hello,Spring");

        message.setFrom("2412025035@qq.com");
        message.setTo("2412025035@qq.com");

        mailSender.send(message);

    }

    @SneakyThrows
    @Test
    public  void test2(){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("Spring");
        helper.setText("Hello,Spring",true);
        //附件
        helper.addAttachment("1.jpg",new File("E:\\仓库\\JAVAweb\\javaweb\\javaweb\\note.md"));
        helper.setFrom("2412025035@qq.com");
        helper.setTo("2412025035@qq.com");

        mailSender.send(mimeMessage);
    }
}
