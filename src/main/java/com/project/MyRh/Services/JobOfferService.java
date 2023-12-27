package com.project.MyRh.Services;

import com.project.MyRh.DTO.JobOfferDto;
import com.project.MyRh.DTO.Request.JobOfferRequest;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.JobOffer;
import com.project.MyRh.Repositories.CompanyRepository;
import com.project.MyRh.Repositories.jobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobOfferService {
    private final jobOfferRepository jobOfferRepository;
    private final CompanyRepository companyRepository;
    private final Mapper<JobOffer, JobOfferDto> jobOfferMapper;
    @Autowired
    public JobOfferService(com.project.MyRh.Repositories.jobOfferRepository jobOfferRepository, CompanyRepository companyRepository, Mapper<JobOffer, JobOfferDto> jobOfferMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
        this.jobOfferMapper = jobOfferMapper;
    }

    public List<JobOfferDto> getAllJobOffers(){
        return jobOfferRepository.findAll().stream().map(jobOfferMapper::mapTo).toList();
    }

    public List<JobOfferDto> findOfferByTitle(String title){
        if (jobOfferRepository.findJobOfferByTitle(title) != null){
            return jobOfferRepository.findJobOfferByTitle(title).stream().map(jobOfferMapper::mapTo).toList();
        }else{
            throw new NotFound("No Job Offer Found!");
        }
    }

    public List<JobOfferDto> findOfferByCompany(String company){
        if(companyRepository.findByName(company) != null){
            if (jobOfferRepository.findJobOfferByCompany(companyRepository.findByName(company)) != null){
                return jobOfferRepository.findJobOfferByCompany(companyRepository.findByName(company)).stream().map(jobOfferMapper::mapTo).toList();
            }else{
                throw new NotFound("No Job Offer Found!");
            }
        }else {
            throw new NotFound("No Company Found!");
        }
    }

    @Transactional
    public JobOfferDto saveJobOffer(JobOfferRequest jobOfferRequest){
        System.out.println("====================================");
        System.out.println(jobOfferRequest);
        System.out.println("====================================");
        if (jobOfferRequest != null){
            return jobOfferMapper.mapTo(jobOfferRepository.save(jobOfferRequest.toModel()));
        }else{
            throw new OperationFailed("No values in the request");
        }
    }

    public boolean deleteJobOffer(Integer id){
        if (id != null){
            jobOfferRepository.deleteById(id);
            return true;
        }else {
            throw new OperationFailed("No id, Operation failed!");
        }
    }
}
