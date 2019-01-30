package com.oip.helpdesk.repository;


import com.oip.helpdesk.domain.entities.Dueno;
import com.oip.helpdesk.domain.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Long> {

}