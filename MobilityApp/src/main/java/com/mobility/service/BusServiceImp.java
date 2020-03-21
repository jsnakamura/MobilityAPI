package com.mobility.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobility.entity.Bus;
import com.mobility.repository.BusRepository;

@Service
public class BusServiceImp implements BusService {

	private BusRepository busRepository;

	@Autowired
	public BusServiceImp(BusRepository busRepository) {

		this.busRepository = busRepository;
	}

	@Override
	public List<Bus> findAll() {
		return busRepository.findAll();
	}

	@Override
	public Bus findById(int id) {

		Optional<Bus> result = busRepository.findById(id);

		Bus bus = null;

		if (result.isPresent())
			bus = result.get();

		return bus;
	}

	@Override
	public void save(Bus bus) {

		busRepository.save(bus);
	}

	@Override
	public void deleteById(int id) {

		busRepository.deleteById(id);
	}

}
