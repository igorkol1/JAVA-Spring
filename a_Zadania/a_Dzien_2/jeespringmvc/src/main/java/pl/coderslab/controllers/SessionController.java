package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
public class SessionController {

    @RequestMapping("/loginstart")
    @ResponseBody
    public String loginStart(HttpServletRequest request,
                             HttpServletResponse response) {
        Cookie cookie = WebUtils.getCookie(request, "loginstart");
        if (cookie == null) {
            cookie = new Cookie("loginstart", LocalDateTime.now().toString());
            response.addCookie(cookie);
            return "New login start is set";

        } else {
            return "Login start: " + cookie.getValue();
        }
    }
}
