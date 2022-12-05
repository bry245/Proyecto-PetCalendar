package com.proyectoPetCalendar.service;

import com.proyectoPetCalendar.domain.Citas;
import java.util.List;


public interface CitasService {
    
    public List<Citas> getCitas(); 
        
    public void save(Citas citas);
    
    public void delete(Citas citas);
    
    //public Citas getCitas(Citas citas);
}
