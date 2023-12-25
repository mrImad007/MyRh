package com.project.MyRh.Repositories;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.Models.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
    Company findByName(String name);
}
