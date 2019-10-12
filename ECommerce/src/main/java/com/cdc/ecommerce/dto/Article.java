package com.cdc.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author wujf
 * @ClassName Article
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Data
@Builder
@JsonPropertyOrder(value = {"content","title"})
public class Article {
//    @JsonIgnore
    private Long id;
    @JsonProperty("author")
    private String author;
    private String title;
    private String content;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createTime;
    private List<Reader> reader;
}
