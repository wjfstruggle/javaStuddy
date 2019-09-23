package com.cdc.ecommerce.common.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author wujf
 * @ClassName UploadUtils
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
public class UploadUtils {
    public static void IoReadImage(String imgUrl, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        try {
            // 获取图片存放路径
            ips = new FileInputStream(new File(imgUrl));
            response.setContentType("image/jpeg");
            out = response.getOutputStream();
            // 读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer,0,len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            ips.close();
        }
    }
}
