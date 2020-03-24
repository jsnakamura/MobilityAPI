package com.mobility.MobilityApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "nome")
	private String nome;

	public Bus(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
}
