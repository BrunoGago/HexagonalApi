package com.brunogago.hexagonal.adapters.inbound.consumers.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isCpfValid;

}
