package com.zhong.wu;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/1/20 23:38
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 要获取下载的文件路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/img.png");
        System.out.println("下载的文件的路径："+realPath);
        //  2. 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //  3. 设置想办法让浏览器支持下载我们需要的东西
        //需要中文的话，就进行编码设置
        resp.setHeader("Content-disposition","attachment;filename="+fileName);
      ///  4. 获取下载文件的输入流
        FileInputStream fis = new FileInputStream(realPath);
        //   5. 创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];
        //   6. 获取OutputStream对象
        ServletOutputStream sos = resp.getOutputStream();
        //  7. 将FileOutputStream流写入到buffer缓冲区
         while((len=fis.read(buffer))!=-1){
            sos.write(buffer,0,len);
         }
         fis.close();

        sos.close();

     //   8. 使用OutputStream将缓冲区中的数据输出到客户端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
