package com.brunogago.hexagonal.application.ports.inbound;

import com.brunogago.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
