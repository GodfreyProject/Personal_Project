package com.example.assignmentwebshopproject.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Builder
@AllArgsConstructor

@Getter
@Table(name = "myorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;
    private double totalAmount;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<ShoppingCart> cartItems;

    public Order() {
    }



    public Long getId() {
        return id;
    }

//    private double totalPrice;

    public Double getTotalPrice()
    {
        Double totalAmount = 0.0;
        for (ShoppingCart item : cartItems)
        {
            totalAmount += item.getAmount() * item.getQuantity();
        }
        return  totalAmount;
    }


//    public Order getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public String setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
        return orderDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }
}
