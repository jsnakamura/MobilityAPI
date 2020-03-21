package com.mobility.service;

import java.util.List;

import com.mobility.entity.Bus;

public interface BusService {

	public List<Bus> findAll();
	
	public Bus findById(int id);
	
	public void save(Bus bus);
	
	public void deleteById(int id);
}
