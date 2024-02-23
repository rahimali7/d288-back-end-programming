package com.webApp.demo.services;

import com.webApp.demo.dao.CartRepository;
import com.webApp.demo.dao.CustomerRepository;
import com.webApp.demo.dao.dto.Purchase;
import com.webApp.demo.dao.dto.PurchaseResponse;
import com.webApp.demo.entities.Cart;
import com.webApp.demo.entities.CartItem;
import com.webApp.demo.entities.Customer;
import com.webApp.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Retrieve the order info from dto
        Cart cart = purchase.getCart();

        //Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with order items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // populate customer with the order
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // Set status
        cart.setStatus(StatusType.ordered);

        //save to database
        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //Generate a random UUID
        return UUID.randomUUID().toString();
    }
}
