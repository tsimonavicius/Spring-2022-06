package lt.codeacademy.eshop.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/hello/{pathVariable}")
    public String hello(@PathVariable String pathVariable, @RequestParam String requestParam) {
        System.out.println("PathVariable received: " + pathVariable);
        System.out.println("RequestParam received: " + requestParam);
        return "hello";
    }
}
