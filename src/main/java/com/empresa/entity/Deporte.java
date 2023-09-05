package com.empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "deporte")
public class Deporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeporte;
	private String nombre;
	
}
