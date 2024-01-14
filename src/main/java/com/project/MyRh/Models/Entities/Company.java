package com.project.MyRh.Models.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "Phone is mandatory")
    @Column(unique = true)
    private String phone;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Logo is mandatory")
    private String logo;
    @NotEmpty(message = "OffersCounter is mandatory")
    private Integer offersCounter;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<JobOffer> jobOffers;




    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
