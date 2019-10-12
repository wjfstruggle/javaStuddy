package com.cdc.ecommerce.controller;

import com.cdc.ecommerce.common.utils.AjaxResponse;
import com.cdc.ecommerce.dto.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author wujf
 * @ClassName ArticleRestController
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle:{}" ,article);
        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("saveArticle:{}" ,id);
        return AjaxResponse.success(id);
    }
    @GetMapping(value = "/article/{id}",produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        Article article = Article.builder().id(1L).author("wujf").content("Spring boot学习").title("t1")
                .createTime(new Date()).build();
        return AjaxResponse.success(article);
    }
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public AjaxResponse putArticle(@PathVariable Long id, @RequestBody Article article) {
        log.info("putArticle:{}" ,article);
        return AjaxResponse.success(article);
    }
}
