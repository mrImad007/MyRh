package com.project.MyRh.DTO.Request;

import com.project.MyRh.Models.Entities.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRequest {
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
    @NotBlank(message = "Logo is mandatory")
    private String logo;
    @NotBlank(message = "Description is mandatory")
    private String description;
    private Integer offersCounter;

    public Company toModel(){
        return Company.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .phone(this.phone)
                .address(this.address)
                .logo(this.logo)
                .description(this.description)
                .offersCounter(this.offersCounter)
                .build();
    }
}
