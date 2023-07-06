package com.brunogago.hexagonal.application.core.services;

import com.brunogago.hexagonal.application.ports.inbound.DeleteCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import com.brunogago.hexagonal.application.ports.outbound.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdService implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdService(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
