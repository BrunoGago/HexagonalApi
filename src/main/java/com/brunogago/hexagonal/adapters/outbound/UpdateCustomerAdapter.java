package com.brunogago.hexagonal.adapters.outbound;

import com.brunogago.hexagonal.adapters.outbound.repositories.CustomerRepository;
import com.brunogago.hexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.outbound.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
