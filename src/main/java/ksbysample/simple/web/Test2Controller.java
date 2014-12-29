package ksbysample.simple.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test2")
public class Test2Controller {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "これは /test2 のページです。";
    }

}
