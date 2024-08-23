package com.wang.filedown;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class FileDown extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1、要获取下载文件路径
        String file="G:\\IDEA\\workspace\\JavaWeb\\servlet-03-response\\src\\main\\resources\\1.png";
        //2、下载的文件名
        String filename=file.substring(file.lastIndexOf("\\")+1);
        //3、设置让浏览器支持下载我们需要下载的东西
        resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(filename,"UTF-8"));
        //4、获取下载文件的输入流
        FileInputStream in=new FileInputStream(file);
        //5、创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //6、获取OutputStream对象
        ServletOutputStream out=resp.getOutputStream();
        //7、将FileOutputStream流写入缓冲区  8、使用Outputstream将缓冲区的数据输出到客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        //9、关闭
        in.close();
        out.close();
    }
}
