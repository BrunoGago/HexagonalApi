package com.brunogago.hexagonal.application.core.services;

import com.brunogago.hexagonal.application.ports.inbound.DeleteCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.inbound.FindCustomerByIdInputPort;

public class DeleteCustomerByIdService implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdService deleteCustomerByIdService;

    public DeleteCustomerByIdService(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdService deleteCustomerByIdService) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdService = deleteCustomerByIdService;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdService.delete(id);
    }
}
