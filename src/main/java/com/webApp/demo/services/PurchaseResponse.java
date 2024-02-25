package com.webApp.demo.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PurchaseResponse {
    //private final String cartIsEmpty;

    private final String orderTrackingNumber;

}
