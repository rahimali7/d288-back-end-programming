package com.webApp.demo.controllers;

import com.webApp.demo.services.Purchase;
import com.webApp.demo.services.PurchaseResponse;
import com.webApp.demo.services.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) throws Exception {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);


        return purchaseResponse;
    }


}
