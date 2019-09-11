package com.cdc.springmybastis.controller;

import com.cdc.springmybastis.dto.AccessTokenDTO;
import com.cdc.springmybastis.dto.GitHubUser;
import com.cdc.springmybastis.model.UserCommunity;
import com.cdc.springmybastis.provider.GitHubProvider;
import com.cdc.springmybastis.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: spring-mybastis
 * @description: 获取授权
 * @author: wujf
 * @create: 2019-09-04 11:14
 **/
@RestController
public class AuthorizeController {
    @Autowired(required = false)
    private GitHubProvider gitHubProvider;

    @Autowired(required = false)
    private UserCommunityService userCommunityService;

    @Value(value = "${github.client.id}")
    private String clientId;

    @Value(value = "${github.redirect.uri}")
    private String setRedirectUri;

    @Value(value = "${github.client.secret}")
    private String setClientSecret;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request, HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(setClientSecret);
        accessTokenDTO.setRedirect_uri(setRedirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);
        if (gitHubUser != null) {
            UserCommunity userCommunity = new UserCommunity();
            userCommunity.setAccount_id(String.valueOf(gitHubUser.getId()));
            String token = UUID.randomUUID().toString();
            userCommunity.setToken(token);
            userCommunity.setName(gitHubUser.getName());
            userCommunity.setGmt_create(System.currentTimeMillis());
            userCommunity.setGmt_modified(userCommunity.getGmt_create());
            userCommunityService.insert(userCommunity);
            // 登录成功，写cookie和session
            request.getSession().setAttribute("user",gitHubUser);
            // 存贮cookie
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        } else {
            // 登录失败。重新登录
            return "redirect:/";
        }
    }
}
