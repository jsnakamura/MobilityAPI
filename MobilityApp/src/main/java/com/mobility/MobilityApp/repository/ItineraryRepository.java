package com.mobility.MobilityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobility.MobilityApp.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
