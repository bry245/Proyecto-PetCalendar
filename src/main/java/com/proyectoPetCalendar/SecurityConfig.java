package com.proyectoPetCalendar;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("juan")
                    .password("{noop}123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("pedro")
                    .password("{noop}123")
                    .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{ //Consulta de autorización y asignación de roles 
        http.authorizeRequests()
                .antMatchers("/albergue/nuevo",        "/albergue/guardar", 
                             "/albergue/modificar/**", "/albergue/eliminar/**",
                             "/mascotas/nuevo",       "/mascotas/guardar",
                             "/mascotas/modificar/**","/mascotas/eliminar/**",
                             "/cliente/nuevo",         "/cliente/guardar",  
                             "/cliente/modificar/**",  "/cliente/eliminar/**",
                             "/usuario/listado",  
                             "/usuario/nuevo",         "/usuario/guardar",  
                             "/usuario/modificar/**",  "/usuario/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers("/albergue/listado", "/mascotas/listado",
                             "/cliente/listado")
                    .hasAnyRole("ADMIN","USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } 
}
