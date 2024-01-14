package com.project.MyRh.Models.Entities;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;
    @NotNull(message = "Phone is mandatory")
    @Column(unique = true)
    private Integer phone;
    @NotBlank(message = "Phone is mandatory")
    private String address;
    @NotBlank(message = "Address is mandatory")
    private String experience;
    @NotBlank(message = "Description is mandatory")
    private String education;
    @NotEmpty(message = "Resume is mandatory")
    private String Resume;

    @OneToMany(mappedBy = "applicant")
    private List<Applications> applications;
}
