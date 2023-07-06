package com.brunogago.hexagonal.adapters.inbound.consumers.mapper;

import com.brunogago.hexagonal.adapters.inbound.consumers.messages.CustomerMessage;
import com.brunogago.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomerDomain(CustomerMessage customerMessage);

}
