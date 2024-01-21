package com.project.MyRh.Services;

import com.project.MyRh.DTO.AdminDto;
import com.project.MyRh.DTO.JobOfferDto;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Models.Entities.JobOffer;
import com.project.MyRh.Repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final JobOfferService jobOfferService;
    private final JobOfferRepository jobOfferRepository;

    @Autowired
    public AdminService(JobOfferService jobOfferService, JobOfferRepository jobOfferRepository) {
        this.jobOfferService = jobOfferService;
        this.jobOfferRepository = jobOfferRepository;
    }

    public JobOffer offerValidation(Integer jobOfferId, String status){
        JobOffer jobOffer = jobOfferService.findJobOfferById(jobOfferId);
        jobOffer.setStatus(status);
        if (jobOfferRepository.save(jobOffer) != null){
            return jobOfferRepository.save(jobOffer);
        }else {
            throw new OperationFailed("Couldn't accept this offer ");
        }
    }
}
