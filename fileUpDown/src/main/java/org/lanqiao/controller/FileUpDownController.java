package org.lanqiao.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

@RestController
@RequestMapping("/file")
public class FileUpDownController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        String filePath = file.getOriginalFilename();   //获取文件的名称
        String fileEx = filePath.substring(filePath.lastIndexOf(".")+1,filePath.length());
        if(file!=null){
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            return "文件扩展名"+fileEx;
        }else{
            return "上传失败,文件不存在!";
        }
    }

    //返回文件的存储路径
    @RequestMapping("/getFileUrl")
    public String getFileUrl(){
        URL filePath = this.getClass().getClassLoader().getResource("123.jpeg");
        return "文件的路径:"+filePath;
    }

    public void download() throws Exception{
        FileSystemResource fileSystemResource = new FileSystemResource("123.jpeg");
        
    }

}
