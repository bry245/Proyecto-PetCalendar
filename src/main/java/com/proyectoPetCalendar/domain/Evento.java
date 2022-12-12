
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
@Table(name="evento")
public class Evento implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_evento") 
    private Long idEvento;
    private String titulo;
    private String descripcion;
    private String link;
    

    public Evento() {
    }

    public Evento(String titulo,String descripcion, String link) {
        this.titulo=titulo;
        this.descripcion = descripcion;
        this.link = link;
    }

    
}