package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State extends GenerateID{
    private String name;

    @OneToMany(mappedBy = "state")
    @JsonBackReference
    private List<City> cities = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        State state = (State) o;
        return name.equals(state.name) && Objects.equals(cities, state.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, cities);
    }
}
