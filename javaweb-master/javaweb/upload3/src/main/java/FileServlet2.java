
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/28 22:45
 */
public class FileServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断上传的文件是普通表单还是带文件的表单
        if(!ServletFileUpload.isMultipartContent(req)){
            return ;//终止方法运行，说明这是一个普通的表单，直接返回
        }//如果通过了if，则代表我们的表单是带文件上传的
        //创建上传文件的保存路径，建议放在WEB-INF路径下，用户无法直接访问上传的文件

        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdir();//创建这个目录
        }
        //缓存，临时文件
        //假如文件超过了预期大小，就把他放到一个临时文件中，过几天自动删除，或者提醒用户转存为永久
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        if(!tempFile.exists()){
            tempFile.mkdir();//创建这个临时目录
        }

        //处理上传的文件，一般都需要通过流来获取，我们可以使用request.getInputStream(),原生态的文件上传流获取，非常麻烦
        //所以建议使用Apache的文件上传组件来实现，commons-fileupload,它需要依赖于commons-io组件
//1.创建DiskFileItemFactory对象，处理文件上传或者大小限制的。
        DiskFileItemFactory diskFileItemFactory = getDiskFileItemFactory(tempFile);


        //2.获取ServletFileUpload
        ServletFileUpload servletFileUpload = getServletFileUpload(diskFileItemFactory);


        //3.把前端请求解析，封装成一个FileItem对象
        //需要从ServletFileUpload对象中获取
        try {
            String msg = uploadParseRequest(servletFileUpload, req, uploadPath);

            //servlet转发消息
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("info.jsp").forward(req,resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    public  String uploadParseRequest(ServletFileUpload servletFileUpload,HttpServletRequest req,String uploadPath) throws FileUploadException {
        String msg=new String();
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);

            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通的表单还是带文件的表单
                if (fileItem.isFormField()) {
                    //getFieldName指的是前端表单空间的Name
                    String fieldName = fileItem.getFieldName();
                    String value = fieldName.getBytes(StandardCharsets.UTF_8).toString();
                    System.out.println(fieldName + ":" + value);
                } else {
                    //文件表单

                    //处理文件=====================================
                    String name = fileItem.getName();
                    System.out.println("上传的文件名:" + name);
                    //可能存在文件名不合法的情况
                    if (name.trim().equals("") || name == null) {
                        continue;
                    }
                    //获取上传的文件名  /
                    String fileName = name.substring(name.lastIndexOf("/") + 1);
                    String fileExtName = name.substring(name.lastIndexOf(".") + 1);
                    /*
                    如果文件后缀名fileExtName不是我们所需要的
                    就直接return ,不处理，告诉用户文件类型不正确
                     */
                    System.out.println("文件信息[件名：" + fileName + "--文件类型：" + fileExtName);

                    //可以使用UUID（唯一识别的通行码），保证文件名唯一
                    //UUID.randomUUID(),随机生成一个唯一识别的通行码

                    //网络传输中的东西，都需要序列化
                    //POJO，实体类，如果想要在多个电脑上运行
                    //implements Serializable:标记接口， JVM-->本地方法栈 native-->C++++
                    //JNI= Java Native Interface
                    String uuidPath = UUID.randomUUID().toString();
                    //存放地址===================================
                    //存到哪？uploadPath
                    //文件的真实路径realPath
                    String realPath = uploadPath + "/" + uuidPath;
                    //给每个文件创建一个文件夹
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()) {
                        realPathFile.mkdir();
                    }
                    //文件传输=================================
                    //获得文件上传的流
                    InputStream is = fileItem.getInputStream();

                    //创建一个文件输出流
                    //realPath=真实的文件夹

                    FileOutputStream fos = new FileOutputStream(realPathFile + "/" + fileName);

                    //创建一个缓冲区
                    byte[] buffer = new byte[1024 * 1024];
                    //判断是否读取完毕
                    int len = 0;
                    //如果大于0说明还存在数据
                    while ((len = is.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    is.close();

                    msg = "文件上传成功";
                    fileItem.delete();//上传成功，删除临时文件
                }
            }
        }catch (FileUploadException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
    public ServletFileUpload getServletFileUpload(DiskFileItemFactory diskFileItemFactory){
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        // 可手动设置参数
        servletFileUpload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
                //l:已经读取到的文件大小
                //l1：文件大小
                System.out.println("总大小："+l1+"已上传"+l);
            }
        });
        //处理乱码问题
        servletFileUpload.setHeaderEncoding("UTF-8");
        //设置单个文件能够上传的最大
        servletFileUpload.setFileSizeMax(1024*1024*10);
        //设置总共能够上传的文件大小
        servletFileUpload.setSizeMax(1024*1024*10);


        return servletFileUpload;
    }
    public DiskFileItemFactory getDiskFileItemFactory(File tempFile){
        //1.创建DiskFileItemFactory对象，处理文件上传或者大小限制的。
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //  可手动设置参数
        //通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区的时候，把他放到临时文件中
        diskFileItemFactory.setSizeThreshold(1024*1024);//缓存大小为1M
        diskFileItemFactory.setRepository(tempFile);//临时目录的保存目录，需要一个File



        return diskFileItemFactory;

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
