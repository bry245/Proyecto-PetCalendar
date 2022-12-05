
package com.proyectoPetCalendar.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="veterinaria")
public class Veterinaria implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_veterinaria") 
    private Long idVeterinaria;
    private String nombre;
    private String ubicacion;
    private String telefono;

    public Veterinaria() {
    }

    public Veterinaria(String nombre, String ubicacion, String telefono) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }
    
    
}
