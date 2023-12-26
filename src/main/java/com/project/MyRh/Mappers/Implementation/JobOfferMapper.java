package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.JobOfferDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.JobOffer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class JobOfferMapper implements Mapper<JobOffer, JobOfferDto> {
    private final ModelMapper modelMapper;
    public JobOfferMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public JobOfferDto mapTo(JobOffer jobOffer) {
        return modelMapper.map(jobOffer, JobOfferDto.class);
    }

    @Override
    public JobOffer mapFrom(JobOfferDto jobOfferDto) {
        return  modelMapper.map(jobOfferDto, JobOffer.class);
    }
}
