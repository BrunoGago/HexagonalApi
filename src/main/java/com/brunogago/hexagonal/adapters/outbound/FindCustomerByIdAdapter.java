package com.brunogago.hexagonal.adapters.outbound;

import com.brunogago.hexagonal.adapters.outbound.repositories.CustomerRepository;
import com.brunogago.hexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.outbound.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomerDomain(entity));
    }
}
