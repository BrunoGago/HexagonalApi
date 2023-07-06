package com.brunogago.hexagonal.application.core.services;

import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.inbound.InsertCustomerInputPort;
import com.brunogago.hexagonal.application.ports.outbound.FindAddressByZipCodeOutputPort;
import com.brunogago.hexagonal.application.ports.outbound.InsertCustomerOutputPort;
import com.brunogago.hexagonal.application.ports.outbound.SendCpfForValidationOutputPort;

public class InsertCustomerService implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;


    public InsertCustomerService(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
