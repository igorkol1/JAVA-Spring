package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.services.WorkerService;

import java.util.List;

@Controller
public class WorkersController {

    @Autowired
    WorkerService workerService;

    @GetMapping("/workers")
    public String getWorkers(Model model){
        List<String> workers = workerService.readAllWorkers();
        model.addAttribute("workers",workers);

        model.addAttribute("randomWorker",workerService.readRandomWorker());
        return "workers";
    }

}
