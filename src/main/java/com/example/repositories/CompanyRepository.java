package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
