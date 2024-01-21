package com.project.MyRh.Controllers;

import com.project.MyRh.Models.Entities.JobOffer;
import com.project.MyRh.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/validation")
    public JobOffer jobOfferValidation(@RequestParam Integer jobOfferId, @RequestParam String status){
        return adminService.offerValidation(jobOfferId,status);
    }
}
