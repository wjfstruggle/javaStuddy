package abnormal.cdc.dome;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @program: notes
 * @description: java异常处理
 * @author: wujf
 * @create: 2019-08-14 16:39
 **/
public class Main13 {
  public static void main(String[] args) {
//    Logger logger = Logger.getLogger(Main.class.getName());
//    logger.info("process");
//    Log log = LogFactory.getLog(Main.class);
//    log.info("start...");
//    log.warn("end.");
    byte[] bs = toGBK("中文");
    System.out.println(Arrays.toString(bs));
  }
  static byte[] toGBK(String s) {
    try {
      return s.getBytes("GBK");
    } catch (UnsupportedEncodingException e) {
      System.out.println(e);
      return s.getBytes();
    }
  }
}