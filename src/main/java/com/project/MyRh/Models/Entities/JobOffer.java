package com.project.MyRh.Models.Entities;

import com.project.MyRh.Models.Enums.ContractType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotEmpty(message = "Salary is mandatory")
    private Integer salary;
    @NotBlank(message = "Location is mandatory")
    private String location;
    @NotEmpty(message = "Date is mandatory")
    private Date date;
    @NotBlank(message = "Contract is mandatory")
    private String contract;
    @NotEmpty(message = "ContractType is mandatory")
    private ContractType contractType;
    //relationShips
    @ManyToOne( cascade = CascadeType.ALL)
    private Company company;
    @OneToMany(mappedBy = "jobOffer")
    private List<JobApplicants> jobApplicants;
}
