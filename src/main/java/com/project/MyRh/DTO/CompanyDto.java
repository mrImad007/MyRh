package com.project.MyRh.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    @NotEmpty(message = "Id is mandatory")
    private Integer id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Email is mandatory")
    private String email;
    @NotEmpty(message = "Phone is mandatory")
    private String phone;
    @NotEmpty(message = "Adress is mandatory")
    private String address;
    @NotEmpty(message = "Logo is mandatory")
    private String logo;
    @NotEmpty(message = "Description is mandatory")
    private String description;
}
