package com.project.MyRh.Services;

import com.project.MyRh.Models.Entities.Pack;
import com.project.MyRh.Repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackService {
    private final PackRepository packRepository;

    @Autowired
    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    public Pack findById(Integer packId){
        return packRepository.findById(packId).isPresent() ? packRepository.findById(packId).get() : null;
    }
}
