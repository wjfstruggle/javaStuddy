package cn.springboot.controller;

import cn.springboot.common.util.Base64MultipartFile;
import cn.springboot.common.util.UploadUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author billy
 * @date 2019/8/5 15:32
 * @Description
 */
@Api(value = "通用Controller",tags = {"通用操作接口"})
@Controller
@RequestMapping("/portal")
public class PortalController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    /**
     * @createtime 2017年8月20日17:15:41
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
    @ApiOperation("file图片上传")
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        logger.info("执行图片上传");
        String user = request.getParameter("user");
        logger.info("user:"+user);
        String path = null;
        if(!file.isEmpty()) {
            logger.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
//                    path = realPath + "uploads\\" + trueFileName;
                    path = realPath + trueFileName;
                    logger.info("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    logger.info("文件成功上传到指定目录下");
                }else {
                    logger.info("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            }else {
                logger.info("文件类型为空");
                return "error";
            }
        }else {
            logger.info("没有找到相对应的文件");
            return "error";
        }
        return path;
    }

    /*@RequestMapping(value="/upload3",method=RequestMethod.POST)
    @ResponseBody
    public String base64UpLoad(@RequestBody String base64Data, HttpServletRequest request, HttpServletResponse response){
        try{
            String dataPrix = "";
            String data = "";
            System.out.println(base64Data);
            JSONObject json = JSON.parseObject(base64Data);
            base64Data = json.getString("base64Data");
            System.out.println(base64Data);
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
    }*/
    @ApiOperation("服务器图片显示")
    @RequestMapping(value = "showImg",method = RequestMethod.GET)
    public void IoReadImage(String url,HttpServletResponse response) throws IOException {
        UploadUtils.IoReadImage(url,response);
    }
}
