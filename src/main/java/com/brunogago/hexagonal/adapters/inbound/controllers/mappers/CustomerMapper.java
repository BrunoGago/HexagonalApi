package com.brunogago.hexagonal.adapters.inbound.controllers.mappers;

import com.brunogago.hexagonal.adapters.inbound.controllers.request.CustomerRequest;
import com.brunogago.hexagonal.adapters.inbound.controllers.response.CustomerResponse;
import com.brunogago.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)//ignora esses atributos
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isCpfValid", ignore = true)
    Customer toCustomerDomain(CustomerRequest customerRequest);

    CustomerResponse toCostumerResponse(Customer customer);

}
