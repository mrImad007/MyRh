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
public class Applications {
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


    @Override
    public String toString() {
        return "Applications{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", jobOffer=" + (jobOffer != null ? jobOffer.getTitle() : "null") +
                ", applicant=" + (applicant != null ? applicant.getName() : "null") +
                '}';
    }
}
