package cn.springboot.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author billy
 * @date 2019/8/6 9:45
 * @Description
 */
public class UploadUtils {
    public static String base64UpLoad(String base64Data, HttpServletRequest request){
        try{
            String dataPrix = "";
            String data = "";
            System.out.println(base64Data);
            /*JSONObject json = JSON.parseObject(base64Data);
            base64Data = json.getString("base64Data");
            System.out.println(base64Data);*/
            if(base64Data == null || "".equals(base64Data)){
                throw new Exception("上传失败，上传图片数据为空");
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }else{
                    throw new Exception("上传失败，数据不合法");
                }
            }
            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                throw new Exception("上传图片格式不合法");
            }
            String tempFileName = UUID.randomUUID().toString() + suffix;
            System.out.println(tempFileName);

            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            try{
                //使用apache提供的工具类操作流

                System.out.println(request.getServletContext().getRealPath("/upload"));
                FileUtils.writeByteArrayToFile(new File(request.getServletContext().getRealPath("/upload"), tempFileName), bs);
            }catch(Exception ee){
                throw new Exception("上传失败，写入文件失败，"+ee.getMessage());
            }
            return request.getServletContext().getRealPath("/upload/") + tempFileName;
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * IO流读取图片
     * @param imgUrl 图片url，即图片保存在服务器上的名称
     */
    public static void IoReadImage(String imgUrl, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;

        try {
            //获取图片存放路径
//            String imgPath = upload + "/" + imgUrl;
            ips = new FileInputStream(new File(imgUrl));
            /*String type = imgUrl.substring(imgUrl.indexOf(".")+1);
            if (type.equals("png")){
                response.setContentType("image/png");
            }
            if (type.equals("jpeg")){
                response.setContentType("image/jpeg");
            }*/
            response.setContentType("image/jpeg");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
            ips.close();
        }
    }
}
