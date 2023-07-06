package com.brunogago.hexagonal.application.ports.inbound;

import com.brunogago.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
