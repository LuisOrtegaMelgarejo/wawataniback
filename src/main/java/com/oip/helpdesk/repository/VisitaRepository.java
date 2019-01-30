package com.oip.helpdesk.repository;


import com.oip.helpdesk.domain.entities.Mascota;
import com.oip.helpdesk.domain.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {

    ArrayList<Visita> findByMascotaId(Long id);
}