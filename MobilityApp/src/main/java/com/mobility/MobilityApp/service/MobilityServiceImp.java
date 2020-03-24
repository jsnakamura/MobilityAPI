package com.mobility.MobilityApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.lucene.util.SloppyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobility.MobilityApp.entity.Bus;
import com.mobility.MobilityApp.entity.Itinerary;
import com.mobility.MobilityApp.entity.Location;
import com.mobility.MobilityApp.repository.BusRepository;
import com.mobility.MobilityApp.repository.ItineraryRepository;

@Service
public class MobilityServiceImp implements MobilityService {

	private BusRepository busRepository;
	private ItineraryRepository itineraryRepository;

	@Autowired
	public MobilityServiceImp(BusRepository busRepository, ItineraryRepository itineraryRepository) {
		this.busRepository = busRepository;
		this.itineraryRepository = itineraryRepository;
	}

	@Override
	public List<Bus> findAllBuses() {
		return busRepository.findAll();
	}

	@Override
	public Bus upsertBus(Bus bus) {

		return busRepository.findById(bus.getId()).map(streamBus -> {
			streamBus.setCodigo(bus.getCodigo());
			streamBus.setNome(bus.getNome());
			return busRepository.save(streamBus);
		}).orElseGet(() -> {
			bus.setId(busRepository.findAll().size() + 1);
			return busRepository.save(bus);
		});
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
	public void deleteBusById(int id) {
		busRepository.deleteById(id);
	}

	@Override
	public List<Itinerary> findAllItineraries() {
		return itineraryRepository.findAll();
	}

	@Override
	public Itinerary upsertItinerary(Itinerary itinerary) {

		return itineraryRepository.findById(itinerary.getIdlinha()).map(streamIti -> {
			;
			streamIti.setCodigo(itinerary.getCodigo());
			streamIti.setLocations(itinerary.getLocations());
			return itineraryRepository.save(streamIti);
		}).orElseGet(() -> {
			return itineraryRepository.save(itinerary);
		});
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
	public void deleteItineraryById(int id) {
		itineraryRepository.deleteById(id);
	}

	@Override
	public List<Bus> filterBusesByRadius(double lat, double lng, double radius) {

		List<Bus> listBus = busRepository.findAll();

		List<Itinerary> listItinerary = itineraryRepository.findAll();

		List<Integer> codeList = new ArrayList<>();

		List<Bus> result = new ArrayList<Bus>();

		listItinerary.stream().forEach(itinerary -> {

			List<Location> itiLocations = itinerary.getLocations();

			itiLocations.stream().forEach(location -> {

				double distance = SloppyMath.haversinMeters(lat, lng, location.getLat(), location.getLng()) / 1000;

				if (distance <= radius)
					codeList.add(itinerary.getIdlinha());
			});
		});

		codeList.stream().forEach(code -> {

			listBus.forEach(bus -> {
				if (bus.getId() == code)
					result.add(bus);
			});
		});

		return result.stream().distinct().collect(Collectors.toList());
	}
}
