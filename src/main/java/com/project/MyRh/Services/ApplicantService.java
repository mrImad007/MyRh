package com.project.MyRh.Services;

import com.project.MyRh.DTO.ApplicantDto;
import com.project.MyRh.DTO.Request.ApplicantRequest;
import com.project.MyRh.Exceptions.Exception.AlreadyExisting;
import com.project.MyRh.Exceptions.Exception.InvalidCredentials;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Applicant;
import com.project.MyRh.Repositories.ApplicantRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.NormalizedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    public final ApplicantRepository applicantRepository;
    public final Mapper<Applicant, ApplicantDto> applicantMapper;
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository, Mapper<Applicant, ApplicantDto> applicantMapper) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
    }

    public boolean isEmailValid(String email){
        return new NormalizedValidator().isValid(email,null);
    }

    public List<ApplicantDto> getAll(){
        return applicantRepository.findAll().stream().map(applicantMapper::mapTo).toList();
    }

    public ApplicantDto getByEmail(String email){
        return applicantMapper.mapTo(applicantRepository.getByEmail(email));
    }

    public ApplicantDto saveApplicant(ApplicantRequest applicantRequest){
        try {
            if (isEmailValid(applicantRequest.getEmail())) {
                if (getByEmail(applicantRequest.getEmail()) == null) {
                    return applicantMapper.mapTo(applicantRepository.save(applicantRequest.toModel()));
                } else {
                    throw new AlreadyExisting("Applicant already existing");
                }
            }else {
                throw new InvalidCredentials("Email is not valid");
            }
        } catch (AlreadyExisting e) {
            throw new OperationFailed("Failed to save applicant, email or phone already existing");
        }

    }
}
