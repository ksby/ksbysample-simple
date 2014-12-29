package ksbysample.simple.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "これは /test のページです。Tomcat起動中に文字列を追加してみました。";
    }

    @RequestMapping("/thymeleaf-sample")
    public String thymeleafSample(Model model) {
        model.addAttribute("msg", "引数 model を追加してみました。");
        User user = new User();
        user.setName("田中　太郎");
        user.setTel("03-1234-5678");
        model.addAttribute("user", user);
        return "test/thymeleaf-sample";
    }

    @RequestMapping("/addurl")
    @ResponseBody
    public String addurl() {
        return "これは /test/addurl のページです。";
    }

}
