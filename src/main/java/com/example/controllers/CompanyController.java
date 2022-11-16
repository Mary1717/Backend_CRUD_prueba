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

import com.example.models.Company;
import com.example.repositories.CompanyRepository;

@RestController
@RequestMapping("company")
@CrossOrigin("*")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("")
	public List<Company> findAll(){
		return companyRepository.findAll();
	}

	@GetMapping("{id}")
	public Company findById(@PathVariable int id) {
		return companyRepository.findById(id).orElse(null);
	}

	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping("")
	public Company create (@RequestBody Company company) {
		if(company!=null) {
			return companyRepository.save(company);
		}
		return null;
	}

	@PutMapping("{id}")
	public Company update(@RequestBody Company newCompany, @PathVariable int id) {
		Company company=companyRepository.findById(id).orElse(null);
		if(company!=null && newCompany!=null) {
			company.setNombre(newCompany.getNombre());
		}
		return companyRepository.save(company);
	}

	@DeleteMapping("{id}")
	public boolean deleteById(@PathVariable int id) {
		Company company= companyRepository.findById(id).orElse(null);
		if(company!=null) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;

	}

}
