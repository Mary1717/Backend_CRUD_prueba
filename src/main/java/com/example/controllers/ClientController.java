package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Client;
import com.example.models.Company;
import com.example.repositories.ClientRepository;
import com.example.repositories.CompanyRepository;

@RestController
@RequestMapping("client")
@CrossOrigin("*")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompanyRepository companyRepository;


	@GetMapping("")
	public List<Client> findAll(){

		return clientRepository.findAll();

	}
	@GetMapping("{id}")
	public Client findById(@PathVariable int id) {
		return clientRepository.findById(id).orElse(null);

	}
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping("company/{idCompany}")
	public Client create(@RequestBody Client client, @PathVariable int idCompany) {
		Company company=companyRepository.findById(idCompany).orElse(null);
		
		if(client!=null && company!=null) {
			client.setCompany(company);
			return clientRepository.save(client);
		}
		return null;

	}
	
	@PutMapping("{id}/company/{idCompany}")
	public Client update(@RequestBody Client newClient, @PathVariable int id,@PathVariable int idCompany){
		Company company=companyRepository.findById(idCompany).orElse(null);
		Client client=clientRepository.findById(id).orElse(null);
		System.out.println("ID COMPANY"+ company.getNombre());
		if(client!=null && newClient!=null && company!=null) {
			client.setCompany(company);
			client.setNombre(newClient.getNombre());
			client.setApellidos(newClient.getApellidos());
			return clientRepository.save(client);
		}
		return null;
		
	}
	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id) {
		Client client=clientRepository.findById(id).orElse(null);
		if(client!=null) {
			clientRepository.deleteById(id);
			return true;
		}
		
		return false;
		
	}
	
}
