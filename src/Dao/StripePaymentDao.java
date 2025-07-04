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
            // Get Stripe secret key from system property and trim whitespace
            String key = System.getProperty("STRIPE_SECRET_KEY");

            if (key == null || key.trim().isEmpty()) {
                System.err.println(" Stripe API key is missing or empty.");
                return false;
            }

            Stripe.apiKey = key.trim();  // Important: trim to avoid hidden spaces

            System.out.println(" Stripe API key loaded.");

            // Create payment intent parameters
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) amountInCents)  // Amount in cents (e.g., $10.00 = 1000)
                .setCurrency(currency)
                .setConfirm(true)
                .setPaymentMethod("pm_card_visa")  // Replace or parameterize as needed
                .setAutomaticPaymentMethods(
                    PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                        .setEnabled(true)
                        .setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER)
                        .build()
                )
                .build();

            // Create the payment intent
            PaymentIntent intent = PaymentIntent.create(params);
            System.out.println(" PaymentIntent created: " + intent.getId());

            return intent != null;

        } catch (StripeException e) {
            System.err.println(" Stripe error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(" Unexpected error: " + e.getMessage());
            return false;
        }
    }
}
