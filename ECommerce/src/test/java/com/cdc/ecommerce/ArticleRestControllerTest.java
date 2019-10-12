package com.cdc.ecommerce;

import com.cdc.ecommerce.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
@SpringBootTest
public class ArticleRestControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
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
