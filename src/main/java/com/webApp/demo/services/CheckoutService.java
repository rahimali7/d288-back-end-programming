package com.webApp.demo.services;

import com.webApp.demo.dao.dto.Purchase;
import com.webApp.demo.dao.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
