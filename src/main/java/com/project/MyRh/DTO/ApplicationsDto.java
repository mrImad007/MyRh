package com.project.MyRh.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.MyRh.Models.Entities.Applicant;
import com.project.MyRh.Models.Entities.JobOffer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationsDto {
    @NotEmpty(message = "Id is mandatory")
    private Integer id;
    @NotBlank(message = "Status is mandatory")
    private String status;
    @NotBlank(message = "Date is mandatory")
    private Date date;
    @NotNull(message = "JobOffer is mandatory")
    @JsonIgnore
    private JobOffer jobOffer;
    @NotNull(message = "Applicant is mandatory")
    private Applicant applicant;
}
