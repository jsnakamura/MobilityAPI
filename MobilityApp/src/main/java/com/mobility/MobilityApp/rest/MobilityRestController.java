package com.mobility.MobilityApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobility.MobilityApp.entity.*;
import com.mobility.MobilityApp.exception.*;
import com.mobility.MobilityApp.service.MobilityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Mobility Management System")
public class MobilityRestController {

	private MobilityService mobilityService;

	@Autowired
	public MobilityRestController(MobilityService mobilityService) {
		this.mobilityService = mobilityService;
	}

	@ApiOperation(value = "View list of all buses")
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> listBuses() {

		List<Bus> buses = mobilityService.findAllBuses();

		if (!buses.isEmpty()) {
			return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);
		} else {
			throw new ListBusesNotFoundException("No buses were found.");
		}
	}

	@ApiOperation(value = "Add a new bus")
	@PostMapping("/buses")
	public ResponseEntity<Bus> newBus(@RequestBody Bus bus) {

		try {
			mobilityService.upsertBus(bus);
			return new ResponseEntity<Bus>(bus, HttpStatus.CREATED);

		} catch (Exception e) {
			throw new BusNotFoundException("Fields are nor correct.");
		}

	}

	@ApiOperation(value = "Get a bus by id")
	@GetMapping("/buses/{id}")
	public ResponseEntity<Bus> getBusById(@PathVariable int id) {

		Bus bus = mobilityService.findBusById(id);

		if (bus != null) {
			return new ResponseEntity<Bus>(bus, HttpStatus.OK);
		} else {
			throw new BusNotFoundException("Bus id: " + id + " not found.");
		}
	}

	@ApiOperation(value = "Update bus by id")
	@PutMapping("/buses/{id}")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus, @PathVariable int id) {

		if (bus != null) {

			if (!bus.getCodigo().isBlank() && !bus.getNome().isBlank()) {

				bus.setId(id);
				mobilityService.upsertBus(bus);
				return new ResponseEntity<Bus>(bus, HttpStatus.OK);

			} else {
				throw new BusNotFoundException("Bus fields cannot be null");
			}

		} else {
			throw new BusNotFoundException("Bus cannot be null.");
		}
	}

	@ApiOperation(value = "Delete bus by id")
	@DeleteMapping("/buses/{id}")
	public ResponseEntity<Void> deleteBus(@PathVariable int id) {

		try {
			mobilityService.deleteBusById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new BusNotFoundException("Id not found.");
		}
	}

	@ApiOperation(value = "View list of all itineraries itineraries")
	@GetMapping("/itineraries")
	public ResponseEntity<List<Itinerary>> listItineraries() {

		List<Itinerary> itineraries = mobilityService.findAllItineraries();

		if (!itineraries.isEmpty()) {
			return new ResponseEntity<List<Itinerary>>(itineraries, HttpStatus.OK);
		} else {
			throw new ListItinerariesNotFoundException("No itineraries were found.");
		}
	}

	@ApiOperation(value = "Add a new itinerary")
	@PostMapping("/itineraries")
	public ResponseEntity<Itinerary> newBus(@RequestBody Itinerary itinerary) {

		try {
			mobilityService.upsertItinerary(itinerary);
			return new ResponseEntity<Itinerary>(itinerary, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ItineraryNotFoundException("Fields are not correct.");
		}

	}

	@ApiOperation(value = "Get an itinerary by id")
	@GetMapping("/itineraries/{id}")
	public ResponseEntity<Itinerary> getItineraryById(@PathVariable int id) {

		Itinerary itinerary = mobilityService.findItineraryById(id);

		if (itinerary != null) {
			return new ResponseEntity<Itinerary>(itinerary, HttpStatus.OK);
		} else {
			throw new ItineraryNotFoundException("Itinerary id: " + id + " not found.");
		}
	}

	@ApiOperation(value = "Update an itinerary by id")
	@PutMapping("/itineraries/{id}")
	public ResponseEntity<Itinerary> updateItinerary(@RequestBody Itinerary itinerary, @PathVariable int id) {

		if (itinerary != null) {

			if (!itinerary.getCodigo().isBlank() && !itinerary.getNome().isBlank()) {
				itinerary.setIdlinha(id);
				mobilityService.upsertItinerary(itinerary);
				return new ResponseEntity<Itinerary>(itinerary, HttpStatus.OK);
			} else {
				throw new ItineraryNotFoundException("Itinerary fields cannot be null.");
			}

		} else {
			throw new ItineraryNotFoundException("Itinerary cannot be null.");
		}
	}

	@ApiOperation(value = "Delete an itinerary by id")
	@DeleteMapping("/itineraries/{id}")
	public ResponseEntity<Void> deleteItinerary(@PathVariable int id) {

		try {
			mobilityService.deleteItineraryById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ItineraryNotFoundException("Id not found.");
		}
	}

	@ApiOperation(value = "Get all buses within a radius")
	@PostMapping("/radius")
	public ResponseEntity<List<Bus>> getBusByRadius(@RequestBody RequestEntry requestEntry) {

		List<Bus> buses;

		if (requestEntry != null) {
			buses = mobilityService.filterBusesByRadius(requestEntry.getLat(), requestEntry.getLng(),
					requestEntry.getRadius());
			return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);
		} else {
			throw new BusNotFoundException("Request Entry must not be null.");
		}
	}
}
