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
                    companyRequest.setOffersCounter(3);
                    System.out.println("insideTheService : "+companyRequest);
                    return companyMapper.mapTo(companyRepository.save(companyRequest.toModel()));
                } catch (Exception e) {
                    System.out.println("theException : "+e);
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
                throw new OperationFailed("Couldn't delete company");
            }
        }else {
            throw new NotFound("Company not found");
        }
    }
    public boolean isRequestValid(CompanyRequest companyRequest) {
        return companyRequest != null;
    }

    public CompanyDto basicAuth(String email, String password){
        if (companyRepository.findByEmailAndPassword(email,password) == null){
            throw new NotFound("Company login not found");
        }else {
            return companyMapper.mapTo(companyRepository.findByEmailAndPassword(email,password));
        }
    }

    public Company findById(Integer companyId) {
        return companyRepository.findById(companyId).isPresent() ? companyRepository.findById(companyId).get() : null;
    }

    public Company updateOffersCounter(Company company){
        return company != null ? companyRepository.save(company) : null;
    }
}
