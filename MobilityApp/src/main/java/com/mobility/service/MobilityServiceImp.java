package com.mobility.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobility.entity.Bus;
import com.mobility.entity.Itinerary;
import com.mobility.repository.BusRepository;
import com.mobility.repository.ItineraryRepository;

public class MobilityServiceImp implements MobilityService {

	private BusRepository busRepository;
	private ItineraryRepository itineraryRepository;

	@Autowired
	public MobilityServiceImp(BusRepository busRepository, ItineraryRepository itineraryRepository) {
		super();
		this.busRepository = busRepository;
		this.itineraryRepository = itineraryRepository;
	}

	@Override
	public List<Bus> findAllBuses() {
		return busRepository.findAll();
	}

	@Override
	public Bus findBusById(int id) {

		Optional<Bus> result = busRepository.findById(id);

		Bus bus = null;

		if (result.isPresent())
			bus = result.get();

		return bus;
	}

	@Override
	public void saveBus(Bus bus) {
		busRepository.save(bus);
	}

	@Override
	public void deleteBusById(int id) {
		busRepository.deleteById(id);
	}

	@Override
	public List<Itinerary> findAllItineraries() {
		return itineraryRepository.findAll();
	}

	@Override
	public Itinerary findItineraryById(int id) {

		Optional<Itinerary> result = itineraryRepository.findById(id);

		Itinerary itinerary = null;

		if (result.isPresent())
			itinerary = result.get();

		return itinerary;
	}

	@Override
	public void saveItinerary(Itinerary itinerary) {
		itineraryRepository.save(itinerary);
	}

	@Override
	public void deleteItineraryById(int id) {
		itineraryRepository.deleteById(id);
	}
}
