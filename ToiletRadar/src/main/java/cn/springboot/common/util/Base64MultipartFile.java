package cn.springboot.common.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @author billy
 * @date 2019/8/5 16:17
 * @Description 重写MultipartFile方法
 */
public class Base64MultipartFile implements MultipartFile {
    private final byte[] imgContent;

    private final String header;

    private final String fileName;

    public Base64MultipartFile(byte[] imgContent, String header, String fileName) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
        this.fileName = fileName;
    }

    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return fileName;
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    /*public MultipartFile base64toMultipart(String data, String fileName) {
        try {
            String[] baseStrs = data.split(",");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(baseStrs[1]);
            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new Base64MultipartFile(b, baseStrs[0] , fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
