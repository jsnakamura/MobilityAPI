package com.mobility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobility.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

}
