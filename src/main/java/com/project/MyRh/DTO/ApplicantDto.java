package com.project.MyRh.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private Integer phone;
    @NotBlank
    private String address;
    @NotBlank
    private String experience;
    @NotBlank
    private String education;
}
