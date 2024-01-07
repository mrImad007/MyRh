package com.project.MyRh.Services;


import com.project.MyRh.DTO.JobApplicantsDto;
import com.project.MyRh.DTO.Request.ApplicantRequest;
import com.project.MyRh.DTO.Request.JobApplicantsRequest;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.JobApplicants;
import com.project.MyRh.Repositories.JobApplicantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicantsService {
    private final JobApplicantsRepository jobApplicantsRepository;
    private final ApplicantService applicantService;
    private final Mapper<JobApplicants, JobApplicantsDto> jobApplicantsMapper;
    @Autowired
    public JobApplicantsService(JobApplicantsRepository jobApplicantsRepository, ApplicantService applicantService, Mapper<JobApplicants, JobApplicantsDto> jobApplicantsMapper) {
        this.jobApplicantsRepository = jobApplicantsRepository;
        this.applicantService = applicantService;
        this.jobApplicantsMapper = jobApplicantsMapper;

    }

    public JobApplicantsDto findById(Integer id) {
        Optional<JobApplicants> jobApplicants = jobApplicantsRepository.findById(id);
        if (jobApplicants.isPresent()){
            return jobApplicantsMapper.mapTo(jobApplicants.get());
        }else {
            throw new NotFound("JobApplicants not found");
        }
    }

    public List<JobApplicantsDto> findByJobOffer(Integer jobOffer_id){
        return jobApplicantsRepository.findByJobOffer_Id(jobOffer_id).stream().map(jobApplicantsMapper::mapTo).toList();
    }

    public JobApplicantsDto findByApplicant_IdAndJobOffer_Id(Integer applicant_id, Integer jobOffer_id) {
        Optional<JobApplicants> jobApplicants = jobApplicantsRepository.findByApplicant_IdAndJobOffer_Id(applicant_id, jobOffer_id);
        if (jobApplicants.isPresent()){
            return jobApplicantsMapper.mapTo(jobApplicants.get());
        }else {
            throw new NotFound("JobApplicants not found");
        }
    }

    public boolean isApplicationNotExisting(Integer applicant_id, Integer jobOffer_id){
        return findByApplicant_IdAndJobOffer_Id(applicant_id, jobOffer_id) == null;
    }

    public JobApplicantsDto save(JobApplicantsRequest jobApplicantsRequest) {
        if (applicantService.getByEmail(jobApplicantsRequest.getEmail()) != null){
            jobApplicantsRequest.setApplicant_id(applicantService.getByEmail(jobApplicantsRequest.getEmail()).getId());
                try {
                    JobApplicants application = jobApplicantsRequest.toModel();
                    application.setDate(new Date());
                    application.setStatus("ON HOLD");
                    return jobApplicantsMapper.mapTo(jobApplicantsRepository.save(application));
                }catch (OperationFailed e){
                    throw new OperationFailed("Failed to create Application!");
                }

        }else {
            try {
                ApplicantRequest applicantRequest = new ApplicantRequest();
                applicantRequest.setName(jobApplicantsRequest.getName());
                applicantRequest.setEmail(jobApplicantsRequest.getEmail());
                applicantRequest.setPhone(jobApplicantsRequest.getPhone());
                applicantRequest.setAddress("adress");
                applicantRequest.setEducation("education");
                applicantRequest.setExperience("exp");

                if (applicantService.saveApplicant(applicantRequest) != null){
                    try {
                        JobApplicants application = jobApplicantsRequest.toModel();
                        application.setDate(new Date());
                        application.setStatus("ON HOLD");
                        return jobApplicantsMapper.mapTo(jobApplicantsRepository.save(application));
                    }catch (OperationFailed e){
                        throw new OperationFailed("Failed to create Application!");
                    }
                }else {
                    throw new OperationFailed("Failed to create Applicant!");
                }
            }catch (OperationFailed e){
                throw new OperationFailed("Failed to create Application!");
            }
        }

    }


}
