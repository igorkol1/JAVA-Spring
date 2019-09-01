package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String showUserAgent(HttpServletRequest request,
                                Model model){
        model.addAttribute("userAgent",request.getHeader("User-Agent"));

        return "userAgent";
    }

}
