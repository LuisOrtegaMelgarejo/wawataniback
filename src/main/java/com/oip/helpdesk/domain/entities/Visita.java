package com.oip.helpdesk.domain.entities;


import javax.persistence.*;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }
}
