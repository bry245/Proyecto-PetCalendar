package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.domain.Usuario;
import com.proyectoPetCalendar.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
  

    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String eliminarUsuario(Usuario usuario, Model model) {
        usuarioService.delete(usuario);
        return "redirect:/usuarios/listadoEliminar";
    }

    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario) {

        return "/usuario/modificar";
        
        
    }
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/login";
    }
    
    @GetMapping("/usuario/modificar/{idUsuario}")/*Este metodo no se utiliza*/
    public String modificarUsuario(Usuario usuario, Model model){
        usuario= usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/login";    
    }
    
    

}
