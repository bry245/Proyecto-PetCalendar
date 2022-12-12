
package com.proyectoPetCalendar.service;

import com.proyectoPetCalendar.dao.EventoDao;
import com.proyectoPetCalendar.domain.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl  implements EventoService {

    @Autowired
    EventoDao eventoDao;

    @Override
        @Transactional
    public List<Evento> getEventos() {
        var Lista=(List<Evento>) eventoDao.findAll();
       return Lista;
    }

   // @Override
    /*public Evento getEvento(Evento evento) {
     
    }*/

        @Transactional
    @Override
    public void save(Evento evento) {
        eventoDao.save(evento);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
        @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
        @Transactional
    public Evento getEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}