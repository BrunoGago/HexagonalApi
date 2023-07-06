package com.brunogago.hexagonal.configs;

import com.brunogago.hexagonal.adapters.outbound.FindAddressByZipCodeAdapter;
import com.brunogago.hexagonal.adapters.outbound.InsertCustomerAdapter;
import com.brunogago.hexagonal.application.core.services.InsertCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    //Criação do BEAN para o serviço de inserir um cliente novo (passando as dependências)
    @Bean
    public InsertCustomerService insertCustomerService(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ){
        return new InsertCustomerService(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }

}
