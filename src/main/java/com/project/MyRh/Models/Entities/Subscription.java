package com.project.MyRh.Models.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "Id is mandatory")
    private Integer id;
    @NotEmpty(message = "Date is mandatory")
    private Date date;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Pack pack;
}
