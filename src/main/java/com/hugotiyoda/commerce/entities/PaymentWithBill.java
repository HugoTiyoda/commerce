package com.hugotiyoda.commerce.entities;

import com.hugotiyoda.commerce.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentWithBill extends Payment {
    private Date dueDate;
    private Date payDay;

    public PaymentWithBill(Integer id, PaymentStatus paymentStatus, Purchase orderPayment, Date dueDate, Date payDay) {
        super(id, paymentStatus, orderPayment);
        this.dueDate = dueDate;
        this.payDay = payDay;
    }
}
