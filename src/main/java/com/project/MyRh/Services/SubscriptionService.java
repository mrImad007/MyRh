package com.project.MyRh.Services;

import com.project.MyRh.DTO.Request.SubscriptionRequest;
import com.project.MyRh.DTO.SubscriptionDto;
import com.project.MyRh.Exceptions.Exception.NotFound;
import com.project.MyRh.Exceptions.Exception.OperationFailed;
import com.project.MyRh.Mappers.Mapper;
import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.Pack;
import com.project.MyRh.Models.Entities.Subscription;
import com.project.MyRh.Repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final CompanyService companyService;
    private final PackService packService;
    private final Mapper<Subscription, SubscriptionDto> subscriptionMapper;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, CompanyService companyService, PackService packService, Mapper<Subscription, SubscriptionDto> subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.companyService = companyService;
        this.packService = packService;
        this.subscriptionMapper = subscriptionMapper;
    }

    public List<SubscriptionDto> getAll(){
        return subscriptionRepository.findAll().stream().map(subscriptionMapper::mapTo).toList();
    }

    public SubscriptionDto saveSubscription(SubscriptionRequest subscriptionRequest){
         if (companyService.findById(subscriptionRequest.getCompany_id()) != null){

             Company company = companyService.findById(subscriptionRequest.getCompany_id());
             Pack pack = packService.findById(subscriptionRequest.getPack_id());

             if (Objects.equals(pack.getName(), "BASIC")){

                 company.setOffersCounter(company.getOffersCounter()+10);

                 if (companyService.updateOffersCounter(company) != null){
                     subscriptionRequest.setDate(new Date());
                     return subscriptionMapper.mapTo(subscriptionRepository.save(subscriptionRequest.toModel()));
                 }else {
                     throw new OperationFailed("Couldn't save Subscription !");
                 }
             } else if (Objects.equals(pack.getName(), "PREMIUM")) {

                 company.setOffersCounter(company.getOffersCounter()+1000000000);

                 if (companyService.updateOffersCounter(company) != null){
                     subscriptionRequest.setDate(new Date());
                     return subscriptionMapper.mapTo(subscriptionRepository.save(subscriptionRequest.toModel()));
                 }else {
                     throw new OperationFailed("Couldn't save Subscription !");
                 }
             }else {
                 throw new NotFound("Pack not found !");
             }
         }else {
             throw new NotFound("Couldn't find the company by its id!");
         }
    }
}
