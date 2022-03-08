package com.hugotiyoda.commerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hugotiyoda.commerce.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends GenerateID {

    private String name;
    private String email;
    private String registrationNumber;
    Integer clientType;

    @JsonManagedReference
    @OneToMany(mappedBy = "clientAdress")
    private List<Adress> adresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "PHONES")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "clientOrder")
    private List<Purchase> ordersList = new ArrayList<>();

    public ClientType getClientType() {
        return ClientType.toEnum(clientType);
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(email, client.email) && registrationNumber.equals(client.registrationNumber) && clientType == client.clientType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, registrationNumber, clientType);
    }
}
