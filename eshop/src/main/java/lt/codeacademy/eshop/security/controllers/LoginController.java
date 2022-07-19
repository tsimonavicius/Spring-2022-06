package lt.codeacademy.eshop.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prisijungimas")
public class LoginController {

    @GetMapping
    public String openLogin() {
        return "loginPage";
    }
}
