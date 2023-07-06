package com.brunogago.hexagonal.adapters.inbound.controllers.response;

import com.brunogago.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private Address address;
    private String cpf;
    private Boolean isCpfValid;
}
