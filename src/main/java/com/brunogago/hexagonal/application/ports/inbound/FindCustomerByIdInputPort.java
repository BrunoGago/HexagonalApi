package com.brunogago.hexagonal.application.ports.inbound;

import com.brunogago.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
