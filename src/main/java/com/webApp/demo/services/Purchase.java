package com.webApp.demo.services;

import com.webApp.demo.entities.Cart;
import com.webApp.demo.entities.CartItem;
import com.webApp.demo.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
