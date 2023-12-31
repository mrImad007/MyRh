package com.project.MyRh.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    @NotEmpty(message = "Id is mandatory")
    private Integer id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Email is mandatory")
    private String email;
    @NotEmpty(message = "Password is mandatory")
    private String phone;
}
