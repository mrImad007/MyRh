package com.project.MyRh.Mappers.Implementation;

import com.project.MyRh.DTO.SubscriptionDto;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Subscription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper implements Mapper<Subscription, SubscriptionDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public SubscriptionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SubscriptionDto mapTo(Subscription subscription) {
        return modelMapper.map(subscription, SubscriptionDto.class);
    }

    @Override
    public Subscription mapFrom(SubscriptionDto subscriptionDto) {
        return modelMapper.map(subscriptionDto, Subscription.class);
    }
}
