package com.scaler.amit.project_ecomservice.dtos;

import com.scaler.amit.project_ecomservice.models.order.Order;
import com.scaler.amit.project_ecomservice.models.order.OrderItem;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Long userId;
    private String status;
    private Date orderDate;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionId;
    private String trackingNumber;
    private double totalAmount;
    private List<OrderItemsDto> items;

    public static OrderDto fromOrder(Order order) {
        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setStatus(order.getOrderStatus().toString());
        dto.setOrderDate(order.getCreated_at());
        dto.setPaymentMethod(order.getPaymentMethod().toString());
        dto.setPaymentStatus(order.getPaymentStatus().toString());
        dto.setTransactionId(order.getTransactionId());
        dto.setTrackingNumber(order.getTrackingNumber());
        dto.setTotalAmount(order.getTotalAmount());

        ArrayList<OrderItemsDto> items = getOrderItemsDtos(order);
        dto.setItems(items);
        return dto;
    }

    private static ArrayList<OrderItemsDto> getOrderItemsDtos(Order order) {
        ArrayList<OrderItemsDto> items = new ArrayList<>();
        for(OrderItem item : order.getOrderItems())
        {
            OrderItemsDto itemDto = new OrderItemsDto();
            itemDto.setId(item.getId());
            itemDto.setProductId(item.getProduct().getId());
            itemDto.setProductName(item.getProduct().getTitle());
            itemDto.setQuantity(item.getQuantity());
            itemDto.setPriceAtPurchase(item.getPriceAtPurchase());
            items.add(itemDto);
        }
        return items;
    }
}
