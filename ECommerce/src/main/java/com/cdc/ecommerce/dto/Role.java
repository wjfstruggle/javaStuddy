package com.cdc.ecommerce.dto;

/**
 * @Author wujf
 * @ClassName Role
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
public class Role {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
