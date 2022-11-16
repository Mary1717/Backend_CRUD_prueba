/**
 * 
 */
package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author maryl
 *
 */
@Entity
@Table(name="empresa")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpresa;
	private String nombre;
	
	//CONTRUCTORES
	public Company() {
		
	}
	
	//GET Y SET
	public Company(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
