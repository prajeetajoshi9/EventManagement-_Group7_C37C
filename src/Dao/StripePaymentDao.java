/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

public class StripePaymentDao {

    public static boolean createPaymentIntent(int amountInCents, String currency) {
        try {
            // Set your Stripe secret key
            Stripe.apiKey =  System.getenv("STRIPE_SECRET_KEY");

            // Create payment intent parameters
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) amountInCents) // e.g., $50.00 = 5000
                .setCurrency(currency)
                .setConfirm(true)
                .setPaymentMethod("pm_card_visa")
                .setAutomaticPaymentMethods(
                    PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                        .setEnabled(true)
                        .setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER)
                        .build()
                )
                .build();

            // Create the payment intent
            PaymentIntent intent = PaymentIntent.create(params);
            System.out.println("PaymentIntent created: " + intent.getId());

            return intent != null;


        } catch (StripeException e) {
            System.out.println("Stripe error: " + e.getMessage());
            return false;
        }
    }
}
