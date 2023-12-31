package com.brunogago.hexagonal.adapters.inbound.controllers;

import com.brunogago.hexagonal.adapters.inbound.controllers.mappers.CustomerMapper;
import com.brunogago.hexagonal.adapters.inbound.controllers.request.CustomerRequest;
import com.brunogago.hexagonal.adapters.inbound.controllers.response.CustomerResponse;
import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.core.services.DeleteCustomerByIdService;
import com.brunogago.hexagonal.application.ports.inbound.DeleteCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.inbound.InsertCustomerInputPort;
import com.brunogago.hexagonal.application.ports.inbound.UpdateCustomerInputPort;
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

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomerDomain(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }


}
