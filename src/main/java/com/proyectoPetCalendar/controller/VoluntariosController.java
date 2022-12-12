package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.domain.Mascota;
import com.proyectoPetCalendar.domain.Voluntario;
import com.proyectoPetCalendar.service.MascotaService;
import com.proyectoPetCalendar.service.VoluntarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class VoluntariosController {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping("/voluntarios/menu")
    public String menu(Model model) {
        return "/mascotas/menu";
    }

    @GetMapping("/voluntarios/listado")
    public String inicio(Model model) {
        var voluntarios = voluntarioService.getVoluntarios();

        model.addAttribute("voluntarios", voluntarios);

        return "/voluntarios/listado";

    }

   /* @GetMapping("/mascotas/listadoEliminar")
    public String listaliminar(Model model) {
        var mascotas = mascotaService.getMascotas();

        model.addAttribute("mascotas", mascotas);

        return "/mascotas/listadoEliminar";

    }*/
    
    /*@GetMapping("/mascota/listadoEditar")
    public String listadoEditar(Model model) {
        var mascotas = mascotaService.getMascotas();

        model.addAttribute("mascotas", mascotas);

        return "/mascotas/actualizar";
    } */

    

    @GetMapping("/voluntarios/nuevo")
    public String nuevoMascota(Voluntario voluntario) {

        return "/mascotas/modificar";
        
        
    }
    @PostMapping("/voluntario/guardar")
    public String guardarVoluntario(Voluntario voluntario){
        voluntarioService.save(voluntario);
        return "redirect:/voluntarios/listado";
    }
    
   
    
    

}
