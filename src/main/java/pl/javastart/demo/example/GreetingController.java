package pl.javastart.demo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class GreetingController {

    @GetMapping("/")
    String greeting() {
        return "greeting";
    }
}
