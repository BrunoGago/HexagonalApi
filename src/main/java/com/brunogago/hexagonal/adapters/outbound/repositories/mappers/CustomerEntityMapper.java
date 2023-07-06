package com.brunogago.hexagonal.adapters.outbound.repositories.mappers;

import com.brunogago.hexagonal.adapters.outbound.repositories.entities.CustomerEntity;
import com.brunogago.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
