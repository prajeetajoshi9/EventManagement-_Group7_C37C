/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// StripePaymentDao.java
package Dao;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

public class StripePaymentDao {

    public static boolean createPaymentIntent(int amountInCents, String currency) {
    try {
        
        Stripe.apiKey = System.getenv("STRIPE_SECRET_KEY");
        PaymentIntentCreateParams.builder()
                .setAmount((long) amountInCents)
                .setCurrency(currency)
                .setConfirm(true)
                .setPaymentMethod("pm_card_visa"); 

        Stripe.apiKey = "sk_test_51RdCA8RtZ2UpBC1VJdoCX4wrvLU59mD7SOKxRRsEvPtxPoENeUS6WZ5W60AQ81HK7luWq1DUswhZiZpyxBD9bDib00vEE01YLx";
      PaymentIntentCreateParams params =
      PaymentIntentCreateParams.builder()
        .setAmount((long) amountInCents) // $50.00 = 5000 cents
        .setCurrency(currency)
        .setConfirm(true)
        .setPaymentMethod("pm_card_visa") // Stripe test payment method
        .setAutomaticPaymentMethods(
            PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                .setEnabled(true)
                .setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER)
                .build()
        )
        .build();


        PaymentIntent intent = PaymentIntent.create(params);
        System.out.println("PaymentIntent created: " + intent.getId());

        return intent != null;

    } catch (StripeException e) {

        System.out.println("Stripe error: " + e.getMessage()); 

        System.out.println("Stripe error: " + e.getMessage()); 

        return false;
    }
}
}
