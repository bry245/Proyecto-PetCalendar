
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
    @Transactional (readOnly=true)
    public List<Evento> getEventos() {
        var Lista=(List<Evento>) eventoDao.findAll();
        return Lista;
    }

    @Override
    @Transactional (readOnly=true)
    public Evento getEvento(Evento evento) {
        return eventoDao.findById(evento.getIdEvento()).orElse(null);    
    }

    @Override
    @Transactional
    public void save(Evento evento) {
       eventoDao.save(evento);
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        eventoDao.delete(evento);
    }
    
}