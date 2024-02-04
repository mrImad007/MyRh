package com.project.MyRh.Web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutPayment {
    private String name;
    private String currency;
    private String successUrl;
    private String cancelUrl;
    private long amount;
    private long quantity;
}
