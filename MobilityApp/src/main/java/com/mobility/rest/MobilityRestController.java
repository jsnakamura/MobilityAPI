package com.mobility.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobility.entity.*;
import com.mobility.exception.*;
import com.mobility.service.BusService;
import com.mobility.service.MobilityService;

@RestController
@RequestMapping("/api")
public class MobilityRestController {

	//private MobilityService mobilityService;

//	@Autowired
//	public MobilityRestController(MobilityService mobilityService) {
//		this.mobilityService = mobilityService;
//	}
	
	private BusService busService;

	@Autowired
	public MobilityRestController(BusService busService) {
		this.busService = busService;
	}
	
	@GetMapping("/buses")
	public String listBuses() {

		// List<Bus> buses = mobilityService.findAllBuses();

		throw new BusNotFoundException();
		
		

//		
//		if (!buses.isEmpty()) {
//			return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);
//		} else {
//			throw new ListBusesNotFoundException("No buses were found.");
//		}
	}

//	@PostMapping("/buses")
//	public ResponseEntity<Bus> newBus(@RequestBody Bus bus) {
//
//		try {
//			mobilityService.upsertBus(bus);
//			return new ResponseEntity<Bus>(bus, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			throw new BusNotFoundException("Fields are nor correct.");
//		}
//
//	}
//
//	@GetMapping("/buses/{id}")
//	public ResponseEntity<Bus> getBusById(@PathVariable int id) {
//
//		Bus bus = mobilityService.findBusById(id);
//
//		if (bus != null) {
//			return new ResponseEntity<Bus>(bus, HttpStatus.OK);
//		} else {
//			throw new BusNotFoundException("Bus id: " + id + " not found.");
//		}
//	}
//
//	@PutMapping("/buses/{id}")
//	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus, @PathVariable int id) {
//
//		if (bus != null) {
//
//			if (!bus.getCode().isBlank() && !bus.getName().isBlank()) {
//
//				bus.setId(id);
//				mobilityService.upsertBus(bus);
//				return new ResponseEntity<Bus>(bus, HttpStatus.OK);
//
//			} else {
//				throw new BusNotFoundException("Bus fields cannot be null");
//			}
//
//		} else {
//			throw new BusNotFoundException("Bus cannot be null.");
//		}
//	}
//
//	@DeleteMapping("/buses/{id}")
//	public ResponseEntity<Void> deleteBus(@PathVariable int id) {
//
//		try {
//			mobilityService.deleteBusById(id);
//			return ResponseEntity.noContent().build();
//		} catch (Exception e) {
//			throw new BusNotFoundException("Id not found.");
//		}
//	}
//
//	@GetMapping("/itineraries")
//	public ResponseEntity<List<Itinerary>> listItineraries() {
//
//		List<Itinerary> itineraries = mobilityService.findAllItineraries();
//
//		if (!itineraries.isEmpty()) {
//			// return ResponseEntity.ok().body(itineraries);
//			return new ResponseEntity<List<Itinerary>>(itineraries, HttpStatus.OK);
//		} else {
//			throw new ListItinerariesNotFoundException("No itineraries were found.");
//		}
//	}
//
//	@PostMapping("/itineraries")
//	public ResponseEntity<Itinerary> newBus(@RequestBody Itinerary itinerary) {
//
//		try {
//			mobilityService.upsertItinerary(itinerary);
//			return new ResponseEntity<Itinerary>(itinerary, HttpStatus.CREATED);
//		} catch (Exception e) {
//			throw new ItineraryNotFoundException("Fields are not correct.");
//		}
//
//	}
//
//	@GetMapping("/itineraries/{id}")
//	public ResponseEntity<Itinerary> getItineraryById(@PathVariable int id) {
//
//		Itinerary itinerary = mobilityService.findItineraryById(id);
//
//		if (itinerary != null) {
//			return new ResponseEntity<Itinerary>(itinerary, HttpStatus.OK);
//		} else {
//			throw new ItineraryNotFoundException("Itinerary id: " + id + " not found.");
//		}
//	}
//
//	@PutMapping("/itineraries/{id}")
//	public ResponseEntity<Itinerary> updateItinerary(@RequestBody Itinerary itinerary, @PathVariable int id) {
//
//		if (itinerary != null) {
//
//			if (!itinerary.getCodigo().isBlank() && !itinerary.getNome().isBlank()) {
//				itinerary.setId(id);
//				mobilityService.upsertItinerary(itinerary);
//				return new ResponseEntity<Itinerary>(itinerary, HttpStatus.OK);
//			} else {
//				throw new ItineraryNotFoundException("Itinerary fields cannot be null.");
//			}
//
//		} else {
//			throw new ItineraryNotFoundException("Itinerary cannot be null.");
//		}
//	}
//
//	@DeleteMapping("/itineraries/{id}")
//	public ResponseEntity<Void> deleteItinerary(@PathVariable int id) {
//
//		try {
//			mobilityService.deleteItineraryById(id);
//			return ResponseEntity.noContent().build();
//		} catch (Exception e) {
//			throw new ItineraryNotFoundException("Id not found.");
//		}
//	}
}
