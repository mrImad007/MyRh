package com.project.MyRh.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer salary;
    @NotBlank(message = "Location is mandatory")
    private String location;
    private Date date;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "jobOffer")
    @JsonIgnore
    private List<JobApplicants> jobApplicants;
}
