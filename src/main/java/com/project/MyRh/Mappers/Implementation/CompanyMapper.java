package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<Company, CompanyDto> {

    private final ModelMapper modelMapper;

    public CompanyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDto mapTo(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public Company mapFrom(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }
}
