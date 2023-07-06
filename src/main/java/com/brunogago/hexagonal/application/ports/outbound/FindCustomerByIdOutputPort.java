package com.brunogago.hexagonal.application.ports.outbound;

import com.brunogago.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
