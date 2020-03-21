package com.mobility.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Bus {

	int id;
	String code;
	String name;
}
