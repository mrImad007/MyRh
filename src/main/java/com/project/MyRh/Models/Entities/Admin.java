package com.project.MyRh.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;


}
