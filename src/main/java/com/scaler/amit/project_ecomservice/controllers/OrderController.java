package com.scaler.amit.project_ecomservice.controllers;

import com.scaler.amit.project_ecomservice.dtos.OrderDto;
import com.scaler.amit.project_ecomservice.exceptions.InsufficientStockException;
import com.scaler.amit.project_ecomservice.exceptions.NotFoundException;
import com.scaler.amit.project_ecomservice.exceptions.PaymentClientException;
import com.scaler.amit.project_ecomservice.models.User;
import com.scaler.amit.project_ecomservice.models.order.Order;
import com.scaler.amit.project_ecomservice.models.order.OrderStatus;
import com.scaler.amit.project_ecomservice.repositories.UserRepository;
import com.scaler.amit.project_ecomservice.services.OrderService;
import com.scaler.amit.project_ecomservice.utils.UserUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserRepository userRepository;
    public OrderController(OrderService orderService, UserRepository userRepository) {
        this.orderService = orderService;
        this.userRepository = userRepository;
    }

    // Place order (initiate payment)
    @PostMapping("/place")
    public ResponseEntity<OrderDto> placeOrder(Authentication authentication) throws InsufficientStockException,
            NotFoundException, PaymentClientException {
        Jwt jwt = ((JwtAuthenticationToken) authentication).getToken();
        User user = UserUtils.createUserIfNotExist(jwt, userRepository);

        Order order = orderService.placeOrder(user.getId());
        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.CREATED);
    }

    // Confirm payment (called by frontend after payment completion)
    @PostMapping("/confirm-payment/{paymentOrderId}")
    public ResponseEntity<OrderDto> confirmPayment(Authentication authentication, @PathVariable String paymentOrderId)
            throws NotFoundException, PaymentClientException {
        Jwt jwt = ((JwtAuthenticationToken) authentication).getToken();
        User user = UserUtils.createUserIfNotExist(jwt, userRepository);

        Order order = orderService.confirmPayment(user.getId(), paymentOrderId);
        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) throws NotFoundException {
        Order order = orderService.getOrder(orderId);
        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(Authentication authentication,
                                                                 @RequestParam(required = false) OrderStatus status) throws NotFoundException {
        Jwt jwt = ((JwtAuthenticationToken) authentication).getToken();
        User user = UserUtils.createUserIfNotExist(jwt, userRepository);
        List<Order> orders = orderService.getAllOrders(user.getId(), status);

        List<OrderDto> orderDtoList =new ArrayList<>();
        for (Order order : orders) {
            orderDtoList.add(OrderDto.fromOrder(order));
        }
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<OrderDto> cancelOrder(@PathVariable Long orderId) throws NotFoundException, PaymentClientException {
        Order order = orderService.cancelOrder(orderId);
        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.OK);
    }
}
