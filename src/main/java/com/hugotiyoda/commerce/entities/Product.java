package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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