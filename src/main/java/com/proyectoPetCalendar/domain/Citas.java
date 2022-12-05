
package com.proyectoPetCalendar.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="citas")
public class Citas implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCita;
    private String fecha;
    
    @JoinColumn(name="id_mascota",referencedColumnName="id_mascota")
    @ManyToOne
    private Mascota mascota;
    
    @JoinColumn(name="id_veterinaria",referencedColumnName="id_veterinaria")
    @ManyToOne
    private Veterinaria veterinaria;

    public Citas() {
    }

    public Citas(Long idCita, String fecha, Mascota mascota, Veterinaria veterinaria) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.mascota = mascota;
        this.veterinaria = veterinaria;
    }   
}
