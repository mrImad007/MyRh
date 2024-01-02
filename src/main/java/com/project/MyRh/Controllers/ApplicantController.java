package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.ApplicantDto;
import com.project.MyRh.DTO.Request.ApplicantRequest;
import com.project.MyRh.Services.ApplicantService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applicant")
@CrossOrigin("http://localhost:4200")
public class ApplicantController {
    private final ApplicantService applicantService;
    @Autowired
    public ApplicantController(ApplicantService applicantService) {this.applicantService = applicantService;}
    @GetMapping
    public List<ApplicantDto> getAll(){return applicantService.getAll();}
    @PostMapping
    public ApplicantDto saveApplicant(@RequestBody @NotNull ApplicantRequest applicantRequest){return applicantService.saveApplicant(applicantRequest);}
}
