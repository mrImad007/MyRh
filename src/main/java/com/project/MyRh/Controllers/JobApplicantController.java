package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.JobApplicantsDto;
import com.project.MyRh.DTO.Request.JobApplicantsRequest;
import com.project.MyRh.Models.Entities.JobApplicants;
import com.project.MyRh.Services.JobApplicantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/application")
public class JobApplicantController {

    private final JobApplicantsService jobApplicantsService;
    @Autowired
    public JobApplicantController(JobApplicantsService jobApplicantsService) {
        this.jobApplicantsService = jobApplicantsService;
    }

    @GetMapping()
    public JobApplicantsDto findCompanyApplications(@RequestParam Integer applicant_id, @RequestParam Integer jobOffer_id){
        return jobApplicantsService.findByApplicant_IdAndJobOffer_Id(applicant_id,jobOffer_id);
    }

    @PostMapping
    public JobApplicantsDto saveApplication(@RequestBody JobApplicantsRequest jobApplicantsRequest){
        return jobApplicantsService.save(jobApplicantsRequest);
    }


}
