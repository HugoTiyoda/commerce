package com.hugotiyoda.commerce.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductPurchased {


    @EmbeddedId
    private PrimaryKeyProductPurchased id = new PrimaryKeyProductPurchased();

    private Double discount;
    private Integer quantity;
    private Double price;

    public ProductPurchased() {

    }

    public ProductPurchased(Purchase purchase, Double discount, Integer quantity, Double price, Product product) {
        id.setProduct(product);
        id.setPurchase(purchase);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public PrimaryKeyProductPurchased getId() {
        return id;
    }

    public Purchase getPurchase() {
        return id.getPurchase();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setId(PrimaryKeyProductPurchased id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}