package com.cdc.springbootdubboconsumer.controller;

import com.cdc.dubboapi.dubbo.api.RemoteUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wujf
 * @ClassName RemoteUserRest
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@RestController
public class RemoteUserController {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserController.class);
    @Autowired(required = false)
    private RemoteUserService remoteUserService;

    @RequestMapping("/index")
    public String dubboTest() {
        log.info("dubbo");
        return remoteUserService.sayHello("word");
    }
}
