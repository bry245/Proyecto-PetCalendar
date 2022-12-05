
package com.proyectoPetCalendar.service;

import com.proyectoPetCalendar.dao.CitasDao;
import com.proyectoPetCalendar.dao.MascotaDao;
import com.proyectoPetCalendar.dao.VeterinariaDao;
import com.proyectoPetCalendar.domain.Citas;
import com.proyectoPetCalendar.domain.Mascota;
import com.proyectoPetCalendar.domain.Veterinaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitasServiceImpl  implements CitasService{

    @Autowired
    private CitasDao citasDao;
    @Autowired
    private MascotaDao mascotaDao;
    @Autowired
    private VeterinariaDao veterinariaDao;
    
    @Override
     @Transactional (readOnly=true)
    public List<Citas> getCitas() {
        return(List<Citas>)citasDao.findAll();
    }

    @Override
    @Transactional 
    public void save(Citas citas) {
        Mascota mascota = citas.getMascota();
        mascota = mascotaDao.save(mascota);
        Veterinaria veterinaria= citas.getVeterinaria();  
        veterinaria = veterinariaDao.save(veterinaria);
        citas.setMascota(mascota);
        citas.setVeterinaria(veterinaria);
    }

    @Override
    @Transactional 
    public void delete(Citas citas) {
        citasDao.delete(citas);
    }

    /*@Override
    @Transactional
    public Citas getCitas(Citas citas) {
        //return citasDao.findAllById(citas.getIdCita()).orElse(null);
    }*/
    
}
