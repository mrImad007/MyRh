package com.project.MyRh.DTO.Request;

import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.JobOffer;
import com.project.MyRh.Models.Enums.ContractType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOfferRequest {
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
    private Integer company_id;

    public JobOffer toModel(){
        Company company = Company.builder().id(this.company_id).build();

        return JobOffer.builder()
                .title(this.title)
                .description(this.description)
                .salary(this.salary)
                .location(this.location)
                .date(this.date)
                .contractType(this.contractType)
                .company(company)
                .build();
    }
}
