package com.brunogago.hexagonal.application.core.services;

import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.outbound.FindCustomerByIdOutputPort;

public class FindCustomerByIdService implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdService(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found!"));
    }
}
