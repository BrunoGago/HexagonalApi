package com.brunogago.hexagonal.adapters.outbound.clients.mappers;

import com.brunogago.hexagonal.adapters.outbound.clients.response.AddressResponse;
import com.brunogago.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddressDomain(AddressResponse addressResponse);
}
