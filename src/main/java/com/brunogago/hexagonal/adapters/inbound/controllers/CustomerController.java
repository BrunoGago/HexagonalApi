package com.brunogago.hexagonal.adapters.inbound.controllers;

import com.brunogago.hexagonal.adapters.inbound.controllers.mappers.CustomerMapper;
import com.brunogago.hexagonal.adapters.inbound.controllers.request.CustomerRequest;
import com.brunogago.hexagonal.adapters.inbound.controllers.response.CustomerResponse;
import com.brunogago.hexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.inbound.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomerDomain(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCostumerResponse(customer);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }


}
