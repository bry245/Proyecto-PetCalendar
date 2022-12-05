package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.service.AlbergueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private AlbergueService albergueService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var albergues = albergueService.getAlbergues();
                
        model.addAttribute("albergues", albergues);
        return "index";
    }
}
