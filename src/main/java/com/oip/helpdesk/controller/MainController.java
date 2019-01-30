package com.oip.helpdesk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.oip.helpdesk.domain.entities.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oip.helpdesk.repository.MascotaRepository;


@CrossOrigin
@RestController
@RequestMapping("/api")

public class MainController {

	@Autowired
	private MascotaRepository mascotaRepository;

	@GetMapping("/mascotas")
	public List<Mascota> getMascotas() {
		List<Mascota> list =  mascotaRepository.findAll();
		return list;
	}
}
