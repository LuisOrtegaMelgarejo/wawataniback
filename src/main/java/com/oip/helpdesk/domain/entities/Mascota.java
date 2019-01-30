package com.oip.helpdesk.domain.entities;


import java.util.*;

import javax.persistence.*;

import com.oip.helpdesk.repository.DuenoRepository;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private
    Integer id;

    @Column(name="name")
    private
    String name;

    @Column(name="type")
    private
    String type;

    @Column(name="path")
    private
    String path;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "dueno_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dueno dueno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
