package com.oip.helpdesk.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @Column(name="id")
    private
    Integer id;

    @Column(name="type")
    private
    String type;

    @Column(name="hora")
    private
    String hora;

    @Column(name="mascota_id")
    private
    Long mascotaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
