package com.project.MyRh.Models.Entities;

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
    @ManyToOne
    private JobOffer job;
    @ManyToOne
    private Applicant applicant;
    private String status;
    private Date date;
}
