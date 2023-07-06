package com.brunogago.hexagonal.application.ports.outbound;

import com.brunogago.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
