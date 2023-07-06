package com.brunogago.hexagonal.adapters.outbound;

import com.brunogago.hexagonal.adapters.outbound.repositories.CustomerRepository;
import com.brunogago.hexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.outbound.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    //Adapter para inserção de cliente
    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
