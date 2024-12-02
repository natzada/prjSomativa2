package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String datahora;
	private String status;
	
	@ManyToOne 
	@JoinColumn (name = "id_pet")
	private Pet pet;
	
	public Long getId() {
		return id;
	}
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;		
	}
	
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}
