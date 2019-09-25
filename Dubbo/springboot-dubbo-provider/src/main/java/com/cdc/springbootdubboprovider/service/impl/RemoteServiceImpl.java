package com.cdc.springbootdubboprovider.service.impl;

import com.cdc.dubboapi.dubbo.api.RemoteUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * @Author wujf
 * @ClassName RemoteServiceimpl
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service("RemoteUserService")
@Component
public class RemoteServiceImpl implements RemoteUserService{
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
