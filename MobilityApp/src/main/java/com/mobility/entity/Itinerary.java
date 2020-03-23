package com.mobility.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="itineraries")
public class Itinerary {

	@Id
	int id;
	String nome;
	String codigo;
	List<Location> locations;
}