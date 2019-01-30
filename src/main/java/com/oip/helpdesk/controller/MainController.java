package com.oip.helpdesk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.oip.helpdesk.domain.entities.Mascota;
import com.oip.helpdesk.domain.entities.Visita;
import com.oip.helpdesk.domain.exceptions.ResourceNotFoundException;
import com.oip.helpdesk.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oip.helpdesk.repository.MascotaRepository;


@CrossOrigin
@RestController
@RequestMapping("/api")

public class MainController {

	@Autowired
	private MascotaRepository mascotaRepository;

	@Autowired
	private VisitaRepository visitaRepository;

	@GetMapping("/mascotas")
	public List<Mascota> getMascotas() {
		List<Mascota> list =  mascotaRepository.findAll();
		return list;
	}

	@GetMapping("/mascotas/{mascota_id}")
	public Mascota getMascotaById(@PathVariable(value = "mascota_id") Long mascota_id) {
		Mascota mascota =  mascotaRepository.findById(mascota_id).orElseThrow(() -> new ResourceNotFoundException("","",""));
		ArrayList<Visita> visitas = visitaRepository.findByMascotaId(mascota_id);
		mascota.setCitas(visitas);
		return mascota;
	}
}
