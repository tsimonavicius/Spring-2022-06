package lt.codeacademy.eshop.products;

import lt.codeacademy.eshop.products.errors.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/makeError")
public class FaultyController {

    @GetMapping
    public String makeError() {
        throw new CustomException();
    }

    @ExceptionHandler(CustomException.class)
    public String handleCustomException() {

        return "error/customExceptionPage";
    }
}
