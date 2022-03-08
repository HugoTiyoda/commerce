package com.hugotiyoda.commerce.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase extends GenerateID {


    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instant;

    @ManyToOne
    @JoinColumn(name = "CLIENT_PURCHASE")
    private Client clientOrder;

    @OneToOne(mappedBy = "purchasePayment", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_ADRESS_ID")
    private Adress deliveryAdress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Purchase pedido = (Purchase) o;
        return Objects.equals(instant, pedido.instant) && Objects.equals(clientOrder, pedido.clientOrder) && Objects.equals(deliveryAdress, pedido.deliveryAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instant, clientOrder, deliveryAdress);
    }
}

