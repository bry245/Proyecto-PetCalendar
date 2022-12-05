package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.service.EventoService;
import com.proyectoPetCalendar.domain.Evento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class EventoController {
    
    @Autowired //Crea instancia de forma automatica
    private EventoService eventoService;
    
    @GetMapping("/evento/listado")
    public String inicio(Model model){        
        var eventos = eventoService.getEventos();
                
        model.addAttribute("eventos", eventos);
        return "/evento/listado";
    }
}