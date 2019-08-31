package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    private Random random;

    public RandomController() {
        this.random = new Random();
    }

    @RequestMapping("/random")
    @ResponseBody
    public String showRandom() {
        return "Wylosowano liczbe " + random.nextInt();
    }

    @RequestMapping("/random/{max}")
    @ResponseBody
    public String showRandom(@PathVariable int max) {
        return "Użytkownik podał max: " + max + ", wylosowana wartość to " + random.nextInt(max);
    }

    @RequestMapping("/random/{min}/{max}")
    @ResponseBody
    public String showRandom(@PathVariable int min, @PathVariable int max) {
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return "Użytkownik podał : " + min + " i " + max + ", wylosowana wartość to " + randomNumber;
    }

}
