package com.brunogago.hexagonal.adapters.outbound.repositories.entities;

import lombok.Data;

@Data
public class AddressEntity {

    private String street;

    private String city;

    private String states;
}
