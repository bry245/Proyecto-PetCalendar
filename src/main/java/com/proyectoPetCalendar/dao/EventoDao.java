package com.proyectoPetCalendar.dao;

import com.proyectoPetCalendar.domain.Evento;
import org.springframework.data.repository.CrudRepository;


public interface EventoDao extends CrudRepository <Evento, Long> {
    
}
