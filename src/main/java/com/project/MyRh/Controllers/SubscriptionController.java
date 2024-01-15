package com.project.MyRh.Controllers;

import com.project.MyRh.DTO.Request.SubscriptionRequest;
import com.project.MyRh.DTO.SubscriptionDto;
import com.project.MyRh.Models.Entities.Subscription;
import com.project.MyRh.Services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<SubscriptionDto> getAll(){
        return subscriptionService.getAll();
    }

    @PostMapping
    public SubscriptionDto saveSubscription(@RequestBody SubscriptionRequest subscriptionRequest){
        System.out.println("=========================== subRequest : "+subscriptionRequest);
        return subscriptionService.saveSubscription(subscriptionRequest);
    }
}
