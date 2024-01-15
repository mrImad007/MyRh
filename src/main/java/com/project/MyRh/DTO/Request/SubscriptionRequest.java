package com.project.MyRh.DTO.Request;

import com.project.MyRh.Models.Entities.Company;
import com.project.MyRh.Models.Entities.Pack;
import com.project.MyRh.Models.Entities.Subscription;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionRequest {
    @NotEmpty(message = "Company_id is mandatory")
    private Integer company_id;
    @NotEmpty(message = "Pack_id is mandatory")
    private Integer pack_id;
    private Date date;

    public Subscription toModel(){
        Company company = Company.builder().id(this.company_id).build();
        Pack pack = Pack.builder().id(this.pack_id).build();

        return Subscription
                .builder()
                .date(this.date)
                .company(company)
                .pack(pack)
                .build();
    }
}
