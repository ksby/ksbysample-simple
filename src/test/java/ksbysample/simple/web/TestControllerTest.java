package ksbysample.simple.web;

import ksbysample.simple.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testIndex() throws Exception {
        this.mvc.perform(get("/test")).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("これは /test のページです。Tomcat起動中に文字列を追加してみました。"));
    }

    @Test
    public void testThymeleafSample() throws Exception {
        this.mvc.perform(get("/test/thymeleaf-sample")).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("test/thymeleaf-sample"))
                .andExpect(content().string(containsString("これは /test/thymeleaf-sample のページです。")))
                .andExpect(xpath("/html/body/span[1]").string("引数 model を追加してみました。"))
                .andExpect(xpath("/html/body/span[2]").string("田中　太郎"))
                .andExpect(xpath("/html/body/span[3]").string("03-1234-5678"));
    }

    @Test
    public void testAddurl() throws Exception {
        this.mvc.perform(get("/test/addurl")).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("これは /test/addurl のページです。"));
    }

}
