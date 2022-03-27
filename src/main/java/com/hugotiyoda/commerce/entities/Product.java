package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends GenerateID{

    private String name;
    private Double price;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "CATEGORY_PRODUCT",
            joinColumns = @JoinColumn(name = "CATEGORY_ID")
            , inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "id.product")
    private Set<ProductPurchased> productPurchaseds= new HashSet<>();

    public Set<ProductPurchased> getProductPurchaseds() {
        return productPurchaseds;
    }

    public void setProductPurchaseds(Set<ProductPurchased> productPurchaseds) {
        this.productPurchaseds = productPurchaseds;
    }

    public List<Purchase> getPurchases(){
        List<Purchase> list = new ArrayList<>();
        for (ProductPurchased x : productPurchaseds ){
            list.add(x.getPurchase());
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price);
    }
}