package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String getFirst(){
        return "first";
    }

    @GetMapping("/second")
    public String getSecond(){
      return "forward:third";
    }

    @GetMapping("/third")
    public String getThird(){
        return "third";
    }

}
