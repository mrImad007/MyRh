package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.ApplicationsDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Applications;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationsMapper implements Mapper<Applications, ApplicationsDto> {
    private final ModelMapper modelMapper;
    @Autowired
    public ApplicationsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ApplicationsDto mapTo(Applications applications) {
        return modelMapper.map(applications, ApplicationsDto.class);
    }

    @Override
    public Applications mapFrom(ApplicationsDto applicationsDto) {
        return modelMapper.map(applicationsDto, Applications.class);
    }
}
