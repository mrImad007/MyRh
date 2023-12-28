package com.project.MyRh.DTO.Request;


import com.project.MyRh.Models.Entities.Applicant;
import com.project.MyRh.Models.Entities.JobApplicants;
import com.project.MyRh.Models.Entities.JobOffer;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicantsRequest {
    @NotNull(message = "JobOffer is mandatory")
    private Integer jobOffer_id;
    @NotNull(message = "Applicant is mandatory")
    private Integer applicant_id;

    public JobApplicants toModel(){
        JobOffer jobOffer = JobOffer.builder().id(this.jobOffer_id).build();
        Applicant applicant = Applicant.builder().id(this.applicant_id).build();

        return JobApplicants.builder()
                .jobOffer(jobOffer)
                .applicant(applicant)
                .build();
    }
}
