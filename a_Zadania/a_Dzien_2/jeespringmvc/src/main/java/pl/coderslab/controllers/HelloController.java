package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String helloPersonal(@PathVariable String firstName,@PathVariable String lastName){
        return "Hello "+firstName+" "+lastName;
    }

}
