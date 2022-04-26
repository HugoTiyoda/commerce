package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postalCode;
    private String street;
    private String district;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "CLIENT_ADRESS")
    private Client clientAdress;


    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adress adress = (Adress) o;
        return Objects.equals(postalCode, adress.postalCode) && Objects.equals(street, adress.street) && Objects.equals(district, adress.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), postalCode, street, district);
    }
}
