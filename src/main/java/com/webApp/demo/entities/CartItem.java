package com.webApp.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;
@Table(name = "cart_items")
@Entity
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne()
    //@Column(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "cartItems")
    private Set<Excursion> excursions;

    @ManyToOne
    //@Column(name = "cart_id")
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    public CartItem() {
    }
}
