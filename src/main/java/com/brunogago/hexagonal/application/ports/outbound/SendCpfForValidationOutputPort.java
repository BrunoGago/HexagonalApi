package com.brunogago.hexagonal.application.ports.outbound;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);
}
