package com.oip.helpdesk.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

import com.oip.helpdesk.domain.entities.Dueno;
import com.oip.helpdesk.domain.entities.Mascota;
import com.oip.helpdesk.domain.entities.Visita;
import com.oip.helpdesk.domain.exceptions.ResourceNotFoundException;
import com.oip.helpdesk.repository.DuenoRepository;
import com.oip.helpdesk.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@Autowired
	private DuenoRepository duenoRepository;

	@GetMapping("/mascotas")
	public List<Mascota> getMascotas() {
		List<Mascota> list =  mascotaRepository.findAll();
		return list;
	}

	@PostMapping("/mascotas/visita")
	public ResponseEntity<?> saveVisita(@RequestBody HashMap<String,String> body){
		Visita visita = new Visita();
		try {
			visita.setType(body.get("type"));
			visita.setMascotaId(new Long(body.get("mascota_id")));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			System.out.println();
			visita.setHora(dateFormat.format(date));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
		visitaRepository.save(visita);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/mascotas/{mascota_id}")
	public Mascota getMascotaById(@PathVariable(value = "mascota_id") Long mascota_id) {
		Mascota mascota =  mascotaRepository.findById(mascota_id).orElseThrow(() -> new ResourceNotFoundException("","",""));
		ArrayList<Visita> visitas = visitaRepository.findByMascotaId(mascota_id);
		mascota.setCitas(visitas);
		return mascota;
	}

	@PostMapping("/mascotas/dueno")
	public ResponseEntity<?> saveDueno(@RequestBody HashMap<String,String> body){
		Dueno dueno = new Dueno();
		try {
			dueno.setName(body.get("name"));
			dueno.setDireccion(body.get("direccion"));
			dueno.setPointx(body.get("pointx"));
			dueno.setPointy(body.get("pointy"));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
		duenoRepository.save(dueno);
		return ResponseEntity.ok().build();
	}

}
