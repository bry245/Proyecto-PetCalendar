
package com.proyectoPetCalendar.controller;

import com.proyectoPetCalendar.dao.UsuarioDao;
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

public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String login(Model model){/*el enlace vacío se devolveria la ventana para ingresar usuario y contraseña (Spring security)*/
        var usuarios= usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }
    
    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario){
        return"/usuario/modificar";
    }
    
    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioService.save(usuario);
        return"/usuario/modificar";/*Redirige al mismo lugar*/
    }
    @GetMapping("/usuario/modificar/{idUsuario}")
    public String modificarUsuario(Usuario usuario,Model model){
     usuario=usuarioService.getUsuario(usuario);
     model.addAttribute("usuario", usuario);
     return"/usuario/modificar";
        
    }  
}
