package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.JobOfferDto;
import com.project.MyRh.DTO.Request.JobOfferRequest;
import com.project.MyRh.Services.JobOfferService;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/offers")
@CrossOrigin("http://localhost:4200")
public class JobOfferController {
    private final JobOfferService jobOfferService;
    @Autowired
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    public List<JobOfferDto> getAllJobOffers(){
        return jobOfferService.getAllJobOffers();
    }

    @GetMapping("/{title}")
    public List<JobOfferDto> findOfferByTitle(@PathVariable @NotNull String title){
        return jobOfferService.findOfferByTitle(title);
    }

    @GetMapping("/company/{company}")
    public List<JobOfferDto> findOfferByCompany(@PathVariable @NotNull String company){
        System.out.println("company name : "+company);
        return jobOfferService.findOfferByCompany(company);
    }

    @PostMapping
    public JobOfferDto saveJobOffer(@RequestBody @NotNull JobOfferRequest jobOfferRequest){
        return jobOfferService.saveJobOffer(jobOfferRequest);
    }

    @PutMapping
    public JobOfferDto updateJobOffer(@RequestBody @NotNull JobOfferRequest jobOfferRequest){
        return jobOfferService.saveJobOffer(jobOfferRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJobOffer(@PathVariable @NotNull Integer id){
        return jobOfferService.deleteJobOffer(id);
    }
}
