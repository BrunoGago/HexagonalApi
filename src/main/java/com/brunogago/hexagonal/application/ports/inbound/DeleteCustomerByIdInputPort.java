package com.brunogago.hexagonal.application.ports.inbound;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
