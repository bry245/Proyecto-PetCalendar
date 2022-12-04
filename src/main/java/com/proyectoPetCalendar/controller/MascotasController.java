package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.domain.Mascota;
import com.proyectoPetCalendar.service.MascotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MascotasController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/mascotas/menu")
    public String menu(Model model) {

        return "/mascotas/menu";
    }

    @GetMapping("/mascotas/listado")
    public String inicio(Model model) {
        var mascotas = mascotaService.getMascotas();/*Metodo del crud que devulve todos los articulos*/

        model.addAttribute("mascotas", mascotas);

        return "/mascotas/listado";

    }

    @GetMapping("/mascotas/listadoEliminar")
    public String listaliminar(Model model) {
        var mascotas = mascotaService.getMascotas();

        model.addAttribute("mascotas", mascotas);

        return "/mascotas/listadoEliminar";

    }
    @GetMapping("/mascota/listadoEditar")
    public String listadoEditar(Model model) {
        var mascotas = mascotaService.getMascotas();

        model.addAttribute("mascotas", mascotas);

        return "/mascotas/actualizar";

    }
    

    @GetMapping("/mascota/eliminar/{idMascota}")
    public String eliminarMascota(Mascota mascota, Model model) {
        mascotaService.delete(mascota);
        return "redirect:/mascotas/listadoEliminar";
    }

    @GetMapping("/mascota/nuevo")
    public String nuevoMascota(Mascota mascota) {

        return "/mascotas/modificar";
        
        
    }
    @PostMapping("/mascota/guardar")
    public String guardarMascota(Mascota mascota){
        mascotaService.save(mascota);
        return "redirect:/mascotas/listado";
    }
    
    @GetMapping("/mascota/modificar/{idMascota}")/*Este metodo no se utiliza*/
    public String modificarMascota(Mascota mascota, Model model){
        mascota= mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascota);
        return "/mascotas/modificar";    
    }
    
    

}
