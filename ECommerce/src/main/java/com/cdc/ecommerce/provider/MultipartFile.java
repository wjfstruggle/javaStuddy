package com.cdc.ecommerce.provider;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * @Author wujf
 * @ClassName MultipartFile
 * @Description 获取到上传文件的各项信息
 * @Date $ $
 * @Param $
 * @return $
 **/
public interface MultipartFile extends InputStreamSource {
    String getName();
    String getOriginalFilename();
    String getContentType();
    boolean isEmpty();
    long getSize();
    byte[] getBytes() throws IOException;
    InputStream getInputStream() throws IOException;
    void transferTo(File dest) throws IOException, IllegalStateException;
}
