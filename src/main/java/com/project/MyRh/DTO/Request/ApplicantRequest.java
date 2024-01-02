package com.project.MyRh.DTO.Request;

import com.project.MyRh.Models.Entities.Applicant;
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
public class ApplicantRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotEmpty
    private Integer phone;
    @NotBlank
    private String address;
    @NotBlank
    private String experience;
    @NotBlank
    private String education;
    @NotBlank
    private String resume;

    public Applicant toModel(){
        return Applicant.builder()
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .address(this.address)
                .experience(this.experience)
                .education(this.education)
                .Resume(this.resume)
                .build();
    }
}
