package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.JobApplicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobApplicantsRepository extends JpaRepository<JobApplicants, Integer>{
    Optional<JobApplicants> findByApplicant_IdAndJobOffer_Id(Integer applicant_id, Integer jobOffer_id);
}
