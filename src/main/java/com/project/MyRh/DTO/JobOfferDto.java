package com.project.MyRh.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Enums.ContractType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOfferDto {
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotEmpty
    private Integer salary;
    @NotBlank
    private String location;
    @NotEmpty
    private Date date;
    @NotEmpty
    private ContractType contractType;
    @NotEmpty
    @JsonIgnore
    private Company company;
}
