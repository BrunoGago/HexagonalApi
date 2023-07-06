package com.brunogago.hexagonal.application.core.services;

import com.brunogago.hexagonal.application.core.domain.Customer;
import com.brunogago.hexagonal.application.ports.inbound.UpdateCustomerInputPort;
import com.brunogago.hexagonal.application.ports.outbound.FindAddressByZipCodeOutputPort;
import com.brunogago.hexagonal.application.ports.outbound.UpdateCustomerOutputPort;

public class UpdateCustomerService implements UpdateCustomerInputPort {

    //Injeção de dependência com a porta que possui o método para verificar se há um cliente
    private final FindCustomerByIdService findCustomerByIdService;

    //Injeção de dependência com a porta que verifica o endereço por cep
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    //Injeção de dependência com a porta que atualiza o customer
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerService(FindCustomerByIdService findCustomerByIdService,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdService = findCustomerByIdService;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }


    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdService.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
