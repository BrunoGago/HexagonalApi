package com.brunogago.hexagonal.application.ports.outbound;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
