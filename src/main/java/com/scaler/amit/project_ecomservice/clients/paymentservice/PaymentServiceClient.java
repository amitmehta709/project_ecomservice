package com.scaler.amit.project_ecomservice.clients.paymentservice;

import com.scaler.amit.project_ecomservice.dtos.PaymentClientDto;
import com.scaler.amit.project_ecomservice.exceptions.PaymentClientException;

public interface PaymentServiceClient {
    PaymentClientDto createPaymentOrder(String invoiceNumber, String currency, Double amount) throws PaymentClientException;
    PaymentClientDto getPaymentStatus(String paymentOrderId) throws PaymentClientException;
    PaymentClientDto processRefund(String paymentOrderId) throws PaymentClientException;
}
