package com.brunogago.hexagonal.application.core.usecases;

import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.inbound.InsertCustomerInputPort;
import com.brunogago.hexagonal.application.ports.outbound.FindAddressByZipCodeOutputPort;
import com.brunogago.hexagonal.application.ports.outbound.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;


    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
