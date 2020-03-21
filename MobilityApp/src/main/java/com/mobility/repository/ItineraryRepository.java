package com.mobility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobility.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
