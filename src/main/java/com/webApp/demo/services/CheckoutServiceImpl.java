package com.webApp.demo.services;

import com.webApp.demo.dao.CartRepository;
import com.webApp.demo.dao.CustomerRepository;
import com.webApp.demo.entities.Cart;
import com.webApp.demo.entities.CartItem;
import com.webApp.demo.entities.Customer;
import com.webApp.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Retrieve the cart info from dto
        Cart cart = purchase.getCart();


        //Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // populate cart with cart item and customer
        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        // Retrieve the customer info
        Customer customer = purchase.getCustomer();

        // populate customer with the order
        customer.add(cart);

        // Set status
        cart.setStatus(StatusType.ordered);

        if (purchase.getCustomer() == null || purchase.getCart() == null || purchase.getCartItems().isEmpty()) {
            return new PurchaseResponse("Cart is empty");
        }
        else {
            //save to database
            customerRepository.save(customer);
            cartRepository.save(cart);
            return new PurchaseResponse(orderTrackingNumber);
        }






    }


    private String generateOrderTrackingNumber() {

        //Generate a random UUID
        return UUID.randomUUID().toString();
    }
}
