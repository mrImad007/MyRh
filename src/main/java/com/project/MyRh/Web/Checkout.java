package com.project.MyRh.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Checkout {
    private String priceId;
    private String successUrl;
    private String cancelUrl;

    public Checkout() {
        super();
    }
}
