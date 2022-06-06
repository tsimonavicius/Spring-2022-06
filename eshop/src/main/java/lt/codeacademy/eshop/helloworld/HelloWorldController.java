package lt.codeacademy.eshop.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {

    @GetMapping("/hello/{pathVariable}")
    public String hello(@PathVariable String pathVariable) {
        System.out.println("PathVariable received: " + pathVariable);
        return "hello";
    }
}
