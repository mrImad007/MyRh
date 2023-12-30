package com.project.MyRh.Services;

import com.project.MyRh.DTO.JobApplicantsDto;
import com.project.MyRh.DTO.Request.JobApplicantsRequest;
import com.project.MyRh.Exceptions.Exception.AlreadyExisting;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.JobApplicants;
import com.project.MyRh.Repositories.JobApplicantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JobApplicantsService {
    private final JobApplicantsRepository jobApplicantsRepository;
    private final Mapper<JobApplicants, JobApplicantsDto> jobApplicantsMapper;
    @Autowired
    public JobApplicantsService(JobApplicantsRepository jobApplicantsRepository, Mapper<JobApplicants, JobApplicantsDto> jobApplicantsMapper) {
        this.jobApplicantsRepository = jobApplicantsRepository;
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
        if (!isApplicationNotExisting(jobApplicantsRequest.getApplicant_id(), jobApplicantsRequest.getJobOffer_id())){
            try {
                JobApplicants application = jobApplicantsRequest.toModel();
                application.setDate(new Date());
                application.setStatus("ON HOLD");
                return jobApplicantsMapper.mapTo(jobApplicantsRepository.save(application));
            }catch (OperationFailed e){
                throw new OperationFailed("Failed to create Application!");
            }
        }else {
            throw new AlreadyExisting("Already Applied to this offer!");
        }
    }


}
