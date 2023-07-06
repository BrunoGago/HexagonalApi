package com.brunogago.hexagonal.adapters.inbound.controllers.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//dados para serem passados na requsição
@Data
public class CustomerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String zipCode;
}
