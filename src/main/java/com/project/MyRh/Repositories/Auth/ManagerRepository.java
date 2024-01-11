package com.project.MyRh.Repositories.Auth;

import com.project.MyRh.Models.Entities.Auth.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail(String email);
    Optional<Manager> findByEmailAndPhone(String email,String phone);
}
