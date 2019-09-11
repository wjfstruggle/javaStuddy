package com.cdc.springmybastis.provider;

import com.cdc.springmybastis.dto.AccessTokenDTO;
import com.cdc.springmybastis.dto.GitHubUser;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * @program: spring-mybastis
 * @description: 方法
 * @author: wujf
 * @create: 2019-09-04 11:34
 **/
@Component
public class GitHubProvider {
  @Value("${github.login.access.token.url}")
  private String loginAccessTokenUrl;

  @Value("${github.user.access.token.url}")
  private String userAccessTokenUrl;

  public String getAccessToken(AccessTokenDTO accessTokenDTO) {
    MediaType mediaType = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
    Request request = new Request.Builder()
        .url(loginAccessTokenUrl)
        .post(body)
        .build();
    try (Response response = client.newCall(request).execute()) {
      String string = response.body().string();
      // 分割获取accesstoken
      String[] array1 = string.split("&");
      String token = array1[0].split("=")[1];
      return token;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
  * @Description:  获取用户token
  * @Param:  OKHTTP方法
  * @return:
  * @Author: wujf
  * @Date:
  */
  public GitHubUser getUser(String accessToken) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(userAccessTokenUrl + accessToken)
        .build();
    try (Response response = client.newCall(request).execute()) {
      String string = response.body().string();
      GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
      System.out.println(gitHubUser);
      return gitHubUser;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
