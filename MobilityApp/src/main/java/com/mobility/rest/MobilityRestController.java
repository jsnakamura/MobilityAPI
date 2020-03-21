package com.mobility.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobility.entity.Bus;
import com.mobility.service.BusService;
import com.mobility.service.ItineraryService;

@RestController
@RequestMapping("/")
public class MobilityRestController {

	@Autowired
	BusService busService;

	@Autowired
	ItineraryService itineraryService;

	
	@GetMapping("/buses")
	public List<Bus> listBuses(Model model) {
		
	}
}
