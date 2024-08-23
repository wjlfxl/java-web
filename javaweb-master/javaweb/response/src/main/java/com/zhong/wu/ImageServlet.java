package com.zhong.wu;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/21 16:36
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器5秒自动刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics graphics = image.getGraphics();
        Graphics2D graphics2d = (Graphics2D) graphics;
        //设置图片的背景颜色
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0,0,80,20);
        //给图片写数据
        graphics2d.setColor(Color.BLUE);
        graphics2d.setFont(new Font(null,Font.BOLD,20));
        graphics2d.drawString(makeNum(),0,20);
        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpg");
        //网站存在缓存，设置让网站不缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("pragma","no-cache");

        //把图片写给浏览器
        boolean write = ImageIO.write(image,"jpg", resp.getOutputStream());

    }
    public String makeNum(){
        Random random = new Random();
        String s = random.nextInt(9999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3 - s.length(); i++) {
            stringBuffer.append("0");
        }
        String s1 = stringBuffer.toString() + s;
        return s1;

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
