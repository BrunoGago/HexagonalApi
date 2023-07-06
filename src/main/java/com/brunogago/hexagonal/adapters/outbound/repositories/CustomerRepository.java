package com.brunogago.hexagonal.adapters.outbound.repositories;

import com.brunogago.hexagonal.adapters.outbound.repositories.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <CustomerEntity, String> {
}
