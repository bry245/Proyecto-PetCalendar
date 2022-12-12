
package com.proyectoPetCalendar.service;

import com.proyectoPetCalendar.dao.CitaDao;
import com.proyectoPetCalendar.dao.MascotaDao;
import com.proyectoPetCalendar.domain.Cita;
import com.proyectoPetCalendar.domain.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl  implements CitaService {

    @Autowired
    CitaDao citaDao;

    @Override
    public List<Cita> getCitas() {

        var Lista=(List<Cita>) citaDao.findAll();
        return Lista;
        
    }

    @Override
    public Cita getCita(Cita cita) {
     return citaDao.findById(cita.getIdCita()).orElse(null);
    }

    @Override
    public void save(Cita cita) {
        citaDao.save(cita);
    
    }

    @Override
    public void delete(Cita cita) {

        citaDao.delete(cita);
    }

}
