package com.oip.helpdesk.domain.entities;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dueno")
public class Dueno {

    @Id
    @Column(name="id")
    private
    Long id;

    @Column(name="name")
    private
    String name;

    @Column(name="direccion")
    private
    String direccion;

    @Column(name="pointx")
    private
    String pointx;

    @Column(name="pointy")
    private
    String pointy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPointx() {
        return pointx;
    }

    public void setPointx(String pointx) {
        this.pointx = pointx;
    }

    public String getPointy() {
        return pointy;
    }

    public void setPointy(String pointy) {
        this.pointy = pointy;
    }
}
