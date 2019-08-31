package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = "text/html; charset=UTF-8")
public class FormController {

    @GetMapping("/form")
    public String getForm() {
        return "Form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String postForm(@RequestParam("number") int number) {
        return "Podany parametr: " + number;
    }

}
