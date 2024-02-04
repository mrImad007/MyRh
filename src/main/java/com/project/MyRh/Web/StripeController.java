package com.project.MyRh.Web;

import com.google.gson.Gson;
import com.stripe.exception.StripeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api")
@Slf4j
@CrossOrigin
public class StripeController {

    private static final String secretKey = "sk_test_51Ofr5CDsIMYcHDHlmGkHSFDSbqPKTyjWk5sJH3MlC8JyGREpDJBFzqoAvGqY9M9Ip32ZkaYTKtnEhz0eodxcvjNr00XghSLwNN";

    private static void init() {
        Stripe.apiKey = secretKey;
    }

    // create a Gson object
    private static Gson gson = new Gson();

    @PostMapping("/payment")
    public ResponseEntity<?> paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
        log.info("in paymentWithCheckoutPage");
        System.out.println(payment);
        init();
        // We create a  stripe session parameters
        SessionCreateParams params = SessionCreateParams.builder()
                // We will use the credit card payment method
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
                .setCancelUrl(
                        payment.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency(payment.getCurrency())
                                                .setUnitAmount(payment.getAmount())
                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData
                                                        .builder()
                                                        .setName(payment.getName())
                                                        .build())
                                                .build())
                                .build())
                .build();
        // create a stripe session
        Session session = Session.create(params);
        // We get the sessionId and we putted inside the response data you can get more info from the session object
        Map<String, String> responseData = new HashMap<>();
        responseData.put("id", session.getId());



        // We can return only the sessionId as a String
        return ResponseEntity.ok().body(responseData);
    }


    @PostMapping("/subscription")

    public String subscriptionWithCheckoutPage(@RequestBody Checkout checkout) throws StripeException {
        init();
        log.info(checkout.getPriceId());
        //String recurringPriceId = checkout.getRecurringPriceId();
        SessionCreateParams params = new SessionCreateParams.Builder().setSuccessUrl(checkout.getSuccessUrl())
                .setCancelUrl(checkout.getCancelUrl()).addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION).addLineItem(new SessionCreateParams.LineItem.Builder()
                        .setQuantity(1L).setPrice(checkout.getPriceId())
                        .setPrice(checkout.getPriceId())
                        .build())
                .build();

        try {
            Session session = Session.create(params);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("sessionId", session.getId());
            return gson.toJson(responseData);
        } catch (Exception e) {
            Map<String, Object> messageData = new HashMap<>();
            messageData.put("message", e.getMessage());
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("error", messageData);
            return gson.toJson(responseData);
        }
    }


}
