package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
