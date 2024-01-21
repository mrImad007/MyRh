package com.project.MyRh.Services;

import com.project.MyRh.DTO.JobOfferDto;
import com.project.MyRh.DTO.Request.JobOfferRequest;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.JobOffer;
import com.project.MyRh.Repositories.CompanyRepository;
import com.project.MyRh.Repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final CompanyRepository companyRepository;
    private final Mapper<JobOffer, JobOfferDto> jobOfferMapper;
    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository, CompanyRepository companyRepository, Mapper<JobOffer, JobOfferDto> jobOfferMapper) {
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

    public List<JobOfferDto> findOfferByCompany(String companyName) {
        Company company = companyRepository.findByName(companyName);

        if (company != null) {
            List<JobOffer> jobOffers = jobOfferRepository.findJobOffersByCompany(company);

            if (jobOffers != null && !jobOffers.isEmpty()) {
                return jobOffers.stream().map(jobOfferMapper::mapTo).toList();
            } else {
                throw new NotFound("No Job Offer Found for Company: " + companyName);
            }
        } else {
            throw new NotFound("No Company Found with name: " + companyName);
        }
    }

    public JobOffer findJobOfferById(Integer jobOfferId){
        if (jobOfferRepository.findById(jobOfferId).isEmpty()){
            return jobOfferRepository.findById(jobOfferId).get();
        }else {
            throw new NotFound("No JobOffer found with this id :"+jobOfferId);
        }
    }


//    @Transactional
    public JobOfferDto saveJobOffer(JobOfferRequest jobOfferRequest){
        if (jobOfferRequest != null){
            Integer offersCounter = companyOffersCounter(jobOfferRequest.getCompany_id());
            if (offersCounter > 0){
                return jobOfferMapper.mapTo(jobOfferRepository.save(jobOfferRequest.toModel()));
            }else {
                throw new OperationFailed("You need to upgrade your Offers Pack !");
            }
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

    public Integer companyOffersCounter(Integer company_id){
        Optional<Company> companyOptional = companyRepository.findById(company_id);
        if (companyOptional.isPresent()){
            Company company = companyOptional.get();
            return company.getOffersCounter();
        }else {
            throw new NotFound("Couldn't find the company by its id !");
        }
    }

}
