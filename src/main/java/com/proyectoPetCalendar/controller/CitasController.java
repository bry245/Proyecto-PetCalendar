package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.domain.Cita;
import com.proyectoPetCalendar.domain.Citas;
import com.proyectoPetCalendar.domain.Mascota;
import com.proyectoPetCalendar.domain.Veterinaria;
import com.proyectoPetCalendar.service.CitaService;
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
    private CitaService citaService;
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
        var citas =citaService.getCitas();
        var veterinarias=veterinariaService.getVeterinarias();
        var mascotas = mascotaService.getMascotas();
        
        model.addAttribute("citas", citas);
        model.addAttribute("veterinarias", veterinarias);
        model.addAttribute("mascotas", mascotas);
        
        return "/citas/listado";
    }
    
    
    @GetMapping("/citas/registrar")
    public String nuevoregistro(Citas citas, Model model){
        
        
        
        return "/citas/modificar";
    }
    
    
    
    
    
  
    
    @GetMapping("/citas/nuevo")
    public String nuevoCitas(Cita cita, Model model){
        var veterinarias= veterinariaService.getVeterinarias();
        var mascotas = mascotaService.getMascotas();
        model.addAttribute("veterinarias", veterinarias);
        model.addAttribute("mascotas", mascotas);
        return "/citas/modificar";
    }
    
    @PostMapping("/citas/guardar")
    public String guardarCitas(Cita cita){
        citaService.save(cita);
        return "redirect:/citas/listado";
    }
    
    @GetMapping ("/citas/modificar/{idCitas}")
    public String modificarCitas(Cita cita, Model model){
        var mascotas = mascotaService.getMascotas();
        var veterinaria = veterinariaService.getVeterinarias();
        model.addAttribute("mascotas",mascotas);
        model.addAttribute("veterinaria",veterinaria);
        /*citas = citasService.getCitas(citas);*/
        model.addAttribute("citas",cita);
        return "/citas/modificar";
    }
    
    @GetMapping ("/citas/eliminar/{idCita}")
    public String eliminarCitas(Cita cita){
        citaService.delete(cita);
        return "redirect:/citas/menu";
    }
    
    @GetMapping("/citas/listadoEliminar")
    public String listaliminar(Model model) {
        var citas = citaService.getCitas();

        model.addAttribute("citas", citas);

        return "/mascotas/listadoEliminar";

    }
    
    @GetMapping("/citas/listadoEditar")
    public String listadoEditar(Model model) {
        var citas = citaService.getCitas();

        model.addAttribute("citas", citas);

        return "/mascotas/actualizar";
    }
}
