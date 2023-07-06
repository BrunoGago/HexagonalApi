package com.brunogago.hexagonal.adapters.inbound.controllers.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;
}
