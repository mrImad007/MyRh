package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ApplicationsRepository extends JpaRepository<Applications, Integer>{
    Optional<Applications> findByApplicant_IdAndJobOffer_Id(Integer applicant_id, Integer jobOffer_id);
    List<Applications> findByJobOffer_Id(Integer jobOffer_id);

}
