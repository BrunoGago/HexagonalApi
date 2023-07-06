package com.brunogago.hexagonal.configs;

import com.brunogago.hexagonal.adapters.outbound.FindAddressByZipCodeAdapter;
import com.brunogago.hexagonal.adapters.outbound.FindCustomerByIdAdapter;
import com.brunogago.hexagonal.adapters.outbound.UpdateCustomerAdapter;
import com.brunogago.hexagonal.application.core.services.FindCustomerByIdService;
import com.brunogago.hexagonal.application.core.services.UpdateCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerByIdConfig {

    //Criação do BEAN para o serviço de atualizar um cliente novo (passando as dependências)
    //Como o FindCustomerByIdService utiliza a porta de entrada e não saida, nao usamos o Adapter, mas sim o próprio serviço
    @Bean
    public UpdateCustomerService updateCustomerService(
            FindCustomerByIdService findCustomerByIdService,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerService(findCustomerByIdService, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
