package com.project.MyRh.DTO;

import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.Pack;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {
    private Integer id;
    private Date date;
    @NotEmpty(message = "Company is mandatory")
    private Company company;
    @NotEmpty(message = "Pack is mandatory")
    private Pack pack;
}
