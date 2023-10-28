package com.example.DBMSPro.Controller;


import com.razorpay.Invoice;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RazorPayController {
    @PostMapping("/newInvoice")
    public String payment() throws RazorpayException {
        RazorpayClient razorpay=new RazorpayClient("[YOUR_KEY_ID]","[YOUR_KEY_SECRET]");
        JSONObject invoiceRequest = new JSONObject();
        invoiceRequest.put("type", "invoice");
        invoiceRequest.put("description", "Test description");
        invoiceRequest.put("partial_payment", true);
        JSONObject customer = new JSONObject();
        customer.put("name", "Gaurav Kumar");
        customer.put("contact","8309818407");
        customer.put("email", "manipradeep693@gmail.com");
        JSONObject billingAddress = new JSONObject();
        billingAddress.put("line1", "Ground & 1st Floor, SJR Cyber Laskar");
        billingAddress.put("line2", "Survey No. 45/1, 45/2 and 46/1");
        billingAddress.put("city", "Bangalore");
        billingAddress.put("state", "Karnataka");
        billingAddress.put("country", "India");
        billingAddress.put("pincode", "560078");
        customer.put("billing_address", billingAddress);
        invoiceRequest.put("customer", customer);
        JSONObject lineItems = new JSONObject();
        List<Object> lines = new ArrayList<>();
        lineItems.put("name", "Subscription");
        lineItems.put("description", "Monthly Subscription");
        lineItems.put("amount", 100);
        lineItems.put("currency", "INR");
        lineItems.put("quantity", 1);
        lines.add(lineItems);
        invoiceRequest.put("line_items", lines);
        invoiceRequest.put("sms_notify", 1);
        invoiceRequest.put("email_notify", 1);
        invoiceRequest.put("expire_by", 3600);
        Invoice invoice = razorpay.invoices.create(invoiceRequest);


        return "Work Done";
    }
}
