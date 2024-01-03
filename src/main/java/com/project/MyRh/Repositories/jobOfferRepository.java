package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jobOfferRepository extends JpaRepository<JobOffer, Integer> {
    List<JobOffer> findJobOfferByTitle(String title);
    List<JobOffer> findJobOffersByCompany(Company company);
}
