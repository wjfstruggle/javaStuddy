package com.cdc.ecommerce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wujf
 * @ClassName StorageProperties
 * @Description 文件保存路径
 * @Date $ $
 * @Param $
 * @return $
 **/
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "/home/jenkins/upload-files/";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
