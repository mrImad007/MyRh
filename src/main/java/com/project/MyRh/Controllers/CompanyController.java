package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.Services.CompanyService;
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
    public CompanyDto getByName(@PathVariable String name){
        return companyService.getByName(name);
    }
}
