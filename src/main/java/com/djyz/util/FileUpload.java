package com.djyz.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@Configuration
public class FileUpload {
    /*上传图片*/
    public String upload(MultipartFile file, HttpSession session) throws IOException {
        //确定上传路径
        String realPath = session.getServletContext().getRealPath("WEB-INF/classes/web-static/images");
        //变成程序中的路径
        File uploadPath = new File(realPath);
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        //确认最终的路径
//        String filename = file.getOriginalFilename();
        String filename = new String(file.getOriginalFilename().getBytes(),"UTF-8");
        String newnewName = UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
        uploadPath = new File(uploadPath+"/"+filename);
        //开始上传
        file.transferTo(uploadPath);
        return filename;
    }

    /*删除服务器图片*/
    public void deleteFile(String picname,HttpSession session){
        String path = session.getServletContext().getRealPath("WEB-INF/classes/web-static/images");
        if(picname != null || !"".equals(picname)){
            File file = new File(path+'/'+picname);
            file.delete();
        }
    }


    /**
     * 文件下载,只需要传入对应文件名字
     */
    public void fileDownload(String fileName, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws Exception {

        String mimeType = session.getServletContext().getMimeType(fileName);
        resp.setContentType(mimeType);
        String agent = req.getHeader("User-Agent");
        String filenameEncoder = "";
        if (agent.contains("MSIE")) {
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        } else {
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
        }
        resp.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
        String path = session.getServletContext().getRealPath("WEB-INF/classes/web-static/images/" + fileName);
        System.out.println("下载文件的路径" + path);
        FileInputStream is = new FileInputStream(path);
        ServletOutputStream os = resp.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = is.read(b)) != -1){
            os.write(b, 0, len);
        }
        os.close();
        is.close();
    }

}
