package com.invillia.reinvent.challenge.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartItem> items = new ArrayList<>();

    public ShoppingCart(Long id) {
    }

    public ShoppingCart(Long id, User user, List<ShoppingCartItem> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public Double getTotal(){
        double sum = 0.0;
        for(ShoppingCartItem x: items){
            sum += x.getSubTotal();
        }
        return sum;
    }
}
