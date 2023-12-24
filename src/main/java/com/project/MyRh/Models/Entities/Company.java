package com.project.MyRh.Models.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}
