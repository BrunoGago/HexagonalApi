package com.brunogago.hexagonal.adapters.outbound;

import com.brunogago.hexagonal.adapters.outbound.clients.FindAddressByZipCodeClient;
import com.brunogago.hexagonal.adapters.outbound.clients.mappers.AddressResponseMapper;
import com.brunogago.hexagonal.adapters.outbound.clients.response.AddressResponse;
import com.brunogago.hexagonal.application.core.domain.Address;
import com.brunogago.hexagonal.application.ports.outbound.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        //chamada do mapper para conversão para a classe domain
        return addressResponseMapper.toAddressDomain(addressResponse);
    }
}
