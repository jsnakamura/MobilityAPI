package com.mobility.MobilityApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itineraries")
public class Itinerary {

	@Id
	@Column(name = "id")
	private int idlinha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "codigo")
	private String codigo;

	@OneToMany(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "itinerary_id", referencedColumnName = "id")
	private List<Location> locations;
}