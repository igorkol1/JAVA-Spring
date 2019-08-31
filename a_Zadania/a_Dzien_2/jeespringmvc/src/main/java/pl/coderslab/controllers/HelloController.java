package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String helloPersonal(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    @RequestMapping("/helloView")
    public String helloView(Model model) {

        LocalDateTime now = LocalDateTime.now();
        String backgroundColor;
        String color;

        if (now.getHour() > 8 && now.getHour() < 20) {
            backgroundColor = "white";
            color = "black";
        } else {
            backgroundColor = "black";
            color = "white";
        }

        model.addAttribute("test", "Test 123");
        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);

        return "home";
    }

}
