/**
 * 
 */
package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author maryl
 *
 */
@Entity
@Table(name="cliente")
public class Client {
	@Id
	private int idCliente;
	private String nombre;
	private String apellidos;
	@JoinColumn(name="id_empresa")
	@OneToOne
	private Company company;


	//CONSTRUCTORES
	public Client() {

	}

	public Client(int idCliente, String nombre, String apellidos, Company company) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.company = company;
	}

	//GET Y SET
	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}	

}
