package com.mobility.service;

import java.util.List;

import com.mobility.entity.Bus;
import com.mobility.entity.Itinerary;

public interface MobilityService {

	public List<Bus> findAllBuses();
	
	public Bus upsertBus(Bus bus); 

	public Bus findBusById(int id);

	public void deleteBusById(int id);
	
	public List<Itinerary> findAllItineraries();
	
	public Itinerary upsertItinerary(Itinerary itinerary);

	public Itinerary findItineraryById(int id);

	public void deleteItineraryById(int id);
	
	public List<Bus> filterBusesByRadius(double lat, double lon, double radius);
}
