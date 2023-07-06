package com.brunogago.hexagonal.configs;

import com.brunogago.hexagonal.adapters.outbound.DeleteCustomerByIdAdapter;
import com.brunogago.hexagonal.adapters.outbound.FindAddressByZipCodeAdapter;
import com.brunogago.hexagonal.adapters.outbound.FindCustomerByIdAdapter;
import com.brunogago.hexagonal.adapters.outbound.InsertCustomerAdapter;
import com.brunogago.hexagonal.application.core.services.DeleteCustomerByIdService;
import com.brunogago.hexagonal.application.core.services.FindCustomerByIdService;
import com.brunogago.hexagonal.application.core.services.InsertCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    //Criação do BEAN para o serviço de deletar um cliente novo (passando as dependências)
    @Bean
    public DeleteCustomerByIdService deleteCustomerByIdService(
            FindCustomerByIdService findCustomerByIdService,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdService(findCustomerByIdService, deleteCustomerByIdAdapter);
    }
}