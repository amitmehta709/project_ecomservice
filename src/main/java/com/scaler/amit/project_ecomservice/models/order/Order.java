package com.scaler.amit.project_ecomservice.models.order;

import com.scaler.amit.project_ecomservice.models.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Order extends BaseModel {
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
    private int userId;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String orderStatus;
}
