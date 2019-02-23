package com.hellospringboot.demo;

import com.hellospringboot.demo.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 运行每个方法前必须运行这个 利用@Before
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void demoApplicationTest() throws Exception {
        // 测试UserController
        RequestBuilder request;

        // 1、get查一下user列表，应该为空
        request = get("/users/getUserList");
        logger.info("{}", request);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        // 2、post提交一个user
        request = post("/users/postUser1")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string("success"));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]"));

        // 4、put修改id为1的user
        request = put("/users/putUser/1")  // @PathParam
                .param("name", "测试终极大师") //@ModelAttribute
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string("success"));

        // 5、get一个id为1的user
        request = get("/users/getUser/1");
        mvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}"));

        // 6、del删除id为1的user
        request = delete("/users/deleteUser/1");
        mvc.perform(request)
                .andExpect(content().string("success"));

        // 7、get查一下user列表，应该为空
        request = get("/users/getUserList");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }

}
