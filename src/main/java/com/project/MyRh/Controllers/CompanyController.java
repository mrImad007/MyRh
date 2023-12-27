package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.DTO.Request.CompanyRequest;
import com.project.MyRh.Services.CompanyService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDto> getAll(){
        return companyService.getAll();
    }

    @GetMapping("/{name}")
    public CompanyDto getByName(@PathVariable @NotNull String name){
        return companyService.getByName(name);
    }

    @PostMapping
    public CompanyDto saveCompany(@RequestBody CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }

    @PutMapping
    public CompanyDto updateCompany(@RequestBody @NotNull CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }

    @DeleteMapping("/{name}")
    public boolean deleteCompany(@PathVariable @NotNull String name){
        return companyService.DeleteCompany(name);
    }

}
