package com.project.MyRh.Repositories;

import com.project.MyRh.Models.Entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepository extends JpaRepository<Pack,Integer> {

}
