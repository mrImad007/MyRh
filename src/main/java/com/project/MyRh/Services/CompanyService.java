package com.project.MyRh.Services;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.DTO.Request.CompanyRequest;
import com.project.MyRh.Exceptions.Exception.*;
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

    public CompanyDto getByName(String name){
        if (companyRepository.findByName(name) == null){
            throw new NotFound("Company not found");
        }else {
            return companyMapper.mapTo(companyRepository.findByName(name));
        }
    }

    public CompanyDto saveCompany(CompanyRequest companyRequest) {
        if (isRequestValid(companyRequest)) {
            if(companyRepository.findByEmailAndPhone(companyRequest.getEmail(),companyRequest.getPhone()) == null) {
                try {
                    return companyMapper.mapTo(companyRepository.save(companyRequest.toModel()));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new OperationFailed("Couldn't save company");
                }
            }else {
                throw new AlreadyExisting("Company already existing");
            }
        }
        else {
            throw new InvalidCredentials("Request is not valid");
        }
    }

    public boolean DeleteCompany(String name){
        if (getByName(name) != null){
            try {
                companyRepository.delete(companyRepository.findByName(name));
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                throw new OperationFailed("Couldn't delete company");
            }
        }else {
                throw new NotFound("Company not found");
        }
    }

    public boolean isRequestValid(CompanyRequest companyRequest) {
        if (companyRequest != null) {
            return true;
        } else {
            return false;
        }
    }
}
