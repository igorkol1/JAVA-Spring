package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultiplyController {

    @GetMapping("/multiply/{size}")
    public String multiply(Model model, @PathVariable int size) {
        model.addAttribute("row",size);
        model.addAttribute("column",size);
        return "multiply";
    }

    @GetMapping("/multiply/{row}/{column}")
    public String multiply(Model model, @PathVariable int row,@PathVariable int column) {
        model.addAttribute("row",row);
        model.addAttribute("column",column);
        return "multiply";
    }

}
