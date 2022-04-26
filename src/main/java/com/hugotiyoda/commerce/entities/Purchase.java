package com.hugotiyoda.commerce.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;


    @ManyToOne
    @JoinColumn(name = "CLIENT_PURCHASE")
    private Client clientOrder;


    @OneToOne(mappedBy = "purchasePayment", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_ADRESS_ID")
    private Adress deliveryAdress;


    @OneToMany(mappedBy = "id.purchase")
    private Set<ProductPurchased> productPurchaseds = new HashSet<>();

    public Set<ProductPurchased> getProductPurchaseds() {
        return productPurchaseds;
    }

    public void setProductPurchaseds(Set<ProductPurchased> productPurchaseds) {
        this.productPurchaseds = productPurchaseds;
    }

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

