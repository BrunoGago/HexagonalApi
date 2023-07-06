package com.brunogago.hexagonal.application.ports.outbound;

import com.brunogago.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
