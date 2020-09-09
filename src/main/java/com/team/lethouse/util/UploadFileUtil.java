package com.team.lethouse.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/7
 * @描述
 */
public class UploadFileUtil {
    public static String upload(MultipartFile pfile,String path){
        try {
            String originalFilename = pfile.getOriginalFilename();
            String exname= "";
            if (originalFilename != null) {
                exname = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String filename=System.currentTimeMillis()+exname;
            File file=new File(path+"/"+filename);
            pfile.transferTo(file);
            return filename;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
