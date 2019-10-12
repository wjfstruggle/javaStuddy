package com.cdc.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Source;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author wujf
 * @ClassName ArticleRestControllerTest
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ArticleRestControllerTest2 {
    @Source
    private MockMvc mockMvc;

    public ArticleRestControllerTest2(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"spring boot学习\",\n" +
                "    \"createTime\": \"2019-10-11 06:43:43\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value("18"))
                .andDo(print())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
