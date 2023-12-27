package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
    Applicant getByEmail(String email);
}
