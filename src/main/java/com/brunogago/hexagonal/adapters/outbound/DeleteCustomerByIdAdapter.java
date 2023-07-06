package com.brunogago.hexagonal.adapters.outbound;

import com.brunogago.hexagonal.adapters.outbound.repositories.CustomerRepository;
import com.brunogago.hexagonal.application.ports.outbound.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
