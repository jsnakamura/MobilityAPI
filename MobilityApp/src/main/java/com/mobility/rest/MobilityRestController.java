package com.mobility.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobility.service.BusService;
import com.mobility.service.ItineraryService;

@RestController
@RequestMapping("/")
public class MobilityRestController {

	@Autowired
	BusService busService;

	@Autowired
	ItineraryService itineraryService;

	
}
