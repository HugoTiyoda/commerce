package com.hugotiyoda.commerce.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrimaryKeyProductPurchased implements Serializable {
    private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name = "ProdutoComprado")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "produto")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrimaryKeyProductPurchased that = (PrimaryKeyProductPurchased) o;
        return Objects.equals(purchase, that.purchase) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), purchase, product);
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
