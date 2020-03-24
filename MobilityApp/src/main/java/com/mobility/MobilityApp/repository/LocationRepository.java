package com.mobility.MobilityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobility.MobilityApp.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
