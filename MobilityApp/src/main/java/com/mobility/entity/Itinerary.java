package com.mobility.entity;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Itinerary {

	int idlinha;
	String nome;
	String codigo;
	List<Location> locations;
}