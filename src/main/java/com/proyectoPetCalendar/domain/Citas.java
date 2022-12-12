
package com.proyectoPetCalendar.domain;

import java.io.Serializable;
import javax.persistence.Column;
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
    @Column(name="id_cita")
    private Long idCita;
    private String mascota;
    private String veterinaria;
    private String fecha;

    public Citas() {
    }

    public Citas( String mascota, String veterinaria, String fecha) {
        
        this.mascota = mascota;
        this.veterinaria = veterinaria;
        this.fecha = fecha;
    }
    
    
      
}
