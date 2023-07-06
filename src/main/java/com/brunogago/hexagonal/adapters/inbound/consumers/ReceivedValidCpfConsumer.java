package com.brunogago.hexagonal.adapters.inbound.consumers;

import com.brunogago.hexagonal.adapters.inbound.consumers.mapper.CustomerMessageMapper;
import com.brunogago.hexagonal.adapters.inbound.consumers.messages.CustomerMessage;
import com.brunogago.hexagonal.application.ports.inbound.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceivedValidCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "gago")

    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomerDomain(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
