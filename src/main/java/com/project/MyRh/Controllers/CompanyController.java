package com.project.MyRh.Controllers;

import com.project.MyRh.Configuration.Cloudinary.FileUpload;
import com.project.MyRh.DTO.CompanyDto;
import com.project.MyRh.DTO.Request.AuthRequest;
import com.project.MyRh.DTO.Request.CompanyRequest;
import com.project.MyRh.Services.CompanyService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/companies")
@CrossOrigin("http://localhost:4200")
public class CompanyController {
    private final CompanyService companyService;
    private final FileUpload fileUpload;

    @Autowired
    public CompanyController(CompanyService companyService, FileUpload fileUpload) {
        this.companyService = companyService;
        this.fileUpload = fileUpload;
    }

    @GetMapping
    public List<CompanyDto> getAll(){
        return companyService.getAll();
    }

    @GetMapping("/{name}")
    public CompanyDto getByName(@PathVariable @NotNull String name){
        return companyService.getByName(name);
    }

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public CompanyDto saveCompany(@RequestPart("companyRequest") CompanyRequest companyRequest, @RequestPart("file") MultipartFile file) throws IOException {

        //companyRequest.setLogo("/Users/imads/Desktop/Junks/"+file.getOriginalFilename());
        String imageURL = fileUpload.uploadFile(file);
        companyRequest.setLogo(imageURL);
        return companyService.saveCompany(companyRequest);
    }

    @PutMapping
    public CompanyDto updateCompany(@RequestBody @NotNull CompanyRequest companyRequest){return companyService.saveCompany(companyRequest);}

    @DeleteMapping("/{name}")
    public boolean deleteCompany(@PathVariable @NotNull String name){
        return companyService.DeleteCompany(name);
    }

    @PostMapping("/auth")
    public CompanyDto authentication(@RequestBody AuthRequest authRequest){
        System.out.println("==============");
        System.out.println(authRequest);
        System.out.println("==============");
        return companyService.basicAuth(authRequest.getEmail(), authRequest.getPassword());
    }

}
