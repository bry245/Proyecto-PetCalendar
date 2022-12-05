package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.domain.Citas;
import com.proyectoPetCalendar.domain.Mascota;
import com.proyectoPetCalendar.domain.Veterinaria;
import com.proyectoPetCalendar.service.CitasService;
import com.proyectoPetCalendar.service.MascotaService;
import com.proyectoPetCalendar.service.VeterinariaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class CitasController {
    
    @Autowired
    private CitasService citasService;
    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private VeterinariaService veterinariaService;
    
    @GetMapping("/citas/menu")
    public String menu(Model model) {
        return "/citas/menu";
    }
    
    @GetMapping("/citas/listado")
    public String inicio (Model model){
        var citas = citasService.getCitas();
        
        model.addAttribute("citas", citas);
        return "/citas/listado";
    }
    
    @GetMapping("/citas/nuevo")
    public String nuevoCitas(Citas citas, Model model){
        return "/citas/modificar";
    }
    
    @PostMapping("/citas/guardar")
    public String guardarCitas(Citas citas){
        citasService.save(citas);
        return "redirect:/citas/listado";
    }
    
    @GetMapping ("/citas/modifica/{idCitas}")
    public String modificarCitas(Citas citas, Model model){
        var mascotas = mascotaService.getMascotas();
        var veterinaria = veterinariaService.getVeterinarias();
        model.addAttribute("mascotas",mascotas);
        model.addAttribute("veterinaria",veterinaria);
        /*citas = citasService.getCitas(citas);*/
        model.addAttribute("citas",citas);
        return "/citas/modifica";
    }
    
    @GetMapping ("/citas/eliminar/{idCitas}")
    public String eliminarCitas(Citas citas){
        citasService.delete(citas);
        return "redirect:/citas/listado";
    }
    
    @GetMapping("/citas/listadoEliminar")
    public String listaliminar(Model model) {
        var citas = citasService.getCitas();

        model.addAttribute("citas", citas);

        return "/mascotas/listadoEliminar";

    }
    
    @GetMapping("/citas/listadoEditar")
    public String listadoEditar(Model model) {
        var citas = citasService.getCitas();

        model.addAttribute("citas", citas);

        return "/mascotas/actualizar";
    }
}
