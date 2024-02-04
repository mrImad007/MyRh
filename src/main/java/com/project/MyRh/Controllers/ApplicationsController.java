package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.ApplicationsDto;
import com.project.MyRh.DTO.Request.ApplicationsRequest;
import com.project.MyRh.Services.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
@CrossOrigin("http://localhost:4200")
public class ApplicationsController {

    private final ApplicationsService applicationsService;
    @Autowired
    public ApplicationsController(ApplicationsService applicationsService) {
        this.applicationsService = applicationsService;
    }

    @GetMapping()
    public ApplicationsDto findCompanyApplication(@RequestParam Integer applicant_id, @RequestParam Integer jobOffer_id){
        return applicationsService.findByApplicant_IdAndJobOffer_Id(applicant_id,jobOffer_id);
    }

    @GetMapping("/{jobOffer_id}")
    public List<ApplicationsDto> findApplicationsByJobOffer(@PathVariable Integer jobOffer_id){
        return applicationsService.findByJobOffer(jobOffer_id);
    }

    @PostMapping()
    public ApplicationsDto saveApplication(@RequestBody ApplicationsRequest applicationsRequest){
        return applicationsService.save(applicationsRequest);
    }

    @PutMapping
    public ApplicationsDto changeApplicationStatus(@RequestBody(required = false) ApplicationsRequest applicationsRequest,@RequestParam String status){
        return applicationsService.changeApplicationStatus(applicationsRequest,status);
    }
}
