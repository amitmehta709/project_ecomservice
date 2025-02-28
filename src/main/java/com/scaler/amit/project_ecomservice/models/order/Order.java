package com.scaler.amit.project_ecomservice.models.order;

import com.scaler.amit.project_ecomservice.models.BaseModel;
import com.scaler.amit.project_ecomservice.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Order extends BaseModel {
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String orderStatus;
}
