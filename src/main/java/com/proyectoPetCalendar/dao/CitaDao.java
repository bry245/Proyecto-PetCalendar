package com.proyectoPetCalendar.dao;

import com.proyectoPetCalendar.domain.Cita;

import org.springframework.data.repository.CrudRepository;


public interface CitaDao extends CrudRepository <Cita, Long> {
    
}
