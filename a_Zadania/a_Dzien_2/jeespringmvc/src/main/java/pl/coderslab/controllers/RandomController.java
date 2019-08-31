package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @RequestMapping("/random")
    @ResponseBody
    public String showRandom(){
        Random random = new Random();
        return "Wylosowano liczbe "+random.nextInt();
    }

}
