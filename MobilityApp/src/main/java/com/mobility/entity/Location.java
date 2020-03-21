package com.mobility.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Location {

	int id;
	Double lat;
	Double lng;
}