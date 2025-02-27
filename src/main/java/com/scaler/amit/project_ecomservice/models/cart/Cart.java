package com.scaler.amit.project_ecomservice.models.cart;

import com.scaler.amit.project_ecomservice.models.BaseModel;
import com.scaler.amit.project_ecomservice.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Cart extends BaseModel {
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> products;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double totalPrice;
}
