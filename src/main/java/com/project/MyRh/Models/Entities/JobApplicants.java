package com.project.MyRh.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobApplicants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String status;
    private Date date;
    @ManyToOne
    @JsonIgnore
    private JobOffer jobOffer;
    @ManyToOne
    @JsonIgnore
    private Applicant applicant;
}
