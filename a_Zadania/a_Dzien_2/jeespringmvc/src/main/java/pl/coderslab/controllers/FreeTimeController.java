package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Controller
public class FreeTimeController {

    @RequestMapping("/free")
    @ResponseBody
    public String freeTimeAction(){
        LocalDateTime now = LocalDateTime.now();
        if(now.getDayOfWeek()== DayOfWeek.SATURDAY || now.getDayOfWeek() == DayOfWeek.SUNDAY){
            return "Wolne";
        }else {
            if(now.getHour()<9 ||now.getHour()>17){
                return "Po Pracy";
            }else {
                return "Pracuje, nie dzwoń.";
            }
        }
    }

}
