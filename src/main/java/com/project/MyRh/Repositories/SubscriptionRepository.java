package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
