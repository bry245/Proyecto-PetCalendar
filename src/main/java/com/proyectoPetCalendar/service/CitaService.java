package com.proyectoPetCalendar.service;

import com.proyectoPetCalendar.domain.Cita;
import com.proyectoPetCalendar.domain.Mascota;
import java.util.List;


public interface CitaService {
    public List<Cita> getCitas(); 
    
    public Cita getCita(Cita cita);
    
    public void save(Cita cita);
    
    public void delete(Cita cita);
}