package com.mobility.service;

import java.util.List;

import com.mobility.entity.Bus;
import com.mobility.entity.Itinerary;

public interface MobilityService {

	public List<Bus> findAllBuses();

	public Bus findBusById(int id);

	public void saveBus(Bus bus);

	public void deleteBusById(int id);
	
	public List<Itinerary> findAllItineraries();

	public Itinerary findItineraryById(int id);

	public void saveItinerary(Itinerary itinerary);

	public void deleteItineraryById(int id);
}
