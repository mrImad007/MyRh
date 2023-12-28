package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.JobApplicantsDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.JobApplicants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobApplicantsMapper implements Mapper<JobApplicants, JobApplicantsDto> {
    private final ModelMapper modelMapper;
    @Autowired
    public JobApplicantsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public JobApplicantsDto mapTo(JobApplicants jobApplicants) {
        return modelMapper.map(jobApplicants, JobApplicantsDto.class);
    }

    @Override
    public JobApplicants mapFrom(JobApplicantsDto jobApplicantsDto) {
        return modelMapper.map(jobApplicantsDto, JobApplicants.class);
    }
}
