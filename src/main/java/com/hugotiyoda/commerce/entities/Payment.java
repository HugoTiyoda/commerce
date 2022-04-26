package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hugotiyoda.commerce.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private PaymentStatus paymentStatus;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "purchase_id")
    @MapsId
    private Purchase purchasePayment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Payment payment = (Payment) o;
        return paymentStatus == payment.paymentStatus && purchasePayment.equals(payment.purchasePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentStatus, purchasePayment);
    }
}
