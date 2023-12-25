package com.project.MyRh.Services;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final Mapper<Company, CompanyDto> companyMapper;
    @Autowired
    public CompanyService(CompanyRepository companyRepository, Mapper<Company, CompanyDto> companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDto> getAll(){
        return companyRepository.findAll().stream().map(companyMapper::mapTo).collect(Collectors.toList());
    }
}
