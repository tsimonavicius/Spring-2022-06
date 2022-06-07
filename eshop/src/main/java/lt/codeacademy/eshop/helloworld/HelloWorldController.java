package lt.codeacademy.eshop.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello";
    }
}
