package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.ApplicantDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper implements Mapper<Applicant, ApplicantDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public ApplicantMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ApplicantDto mapTo(Applicant applicant) {
        return modelMapper.map(applicant,ApplicantDto.class);
    }

    @Override
    public Applicant mapFrom(ApplicantDto applicantDto) {
        return modelMapper.map(applicantDto,Applicant.class);
    }
}
