package com.brunogago.hexagonal.configs;

import com.brunogago.hexagonal.adapters.outbound.FindCustomerByIdAdapter;
import com.brunogago.hexagonal.application.core.services.FindCustomerByIdService;
import com.brunogago.hexagonal.application.ports.outbound.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;

public class FindCustomerByIdConfig {

    //Criação do BEAN para o serviço de achar um cliente novo (passando as dependências)
    @Bean
    public FindCustomerByIdService findCustomerByIdService(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ){
        return new FindCustomerByIdService(findCustomerByIdAdapter);
    }
}
