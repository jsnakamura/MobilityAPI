package com.mobility.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="buses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

	@Id
	@Column(name="id")
	int id;
	@Column(name="code")
	String code;
	@Column(name="name")
	String name;
	
	public Bus(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
