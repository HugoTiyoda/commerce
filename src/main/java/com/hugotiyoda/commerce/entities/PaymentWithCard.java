package com.hugotiyoda.commerce.entities;

import com.hugotiyoda.commerce.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentWithCard extends Payment {
    private Integer parcels;

    public PaymentWithCard(Integer id, PaymentStatus paymentStatus, Purchase orderPayment, Integer parcels) {
        super(id, paymentStatus, orderPayment);
        this.parcels = parcels;
    }
}
