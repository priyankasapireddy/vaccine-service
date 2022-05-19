package com.curelight.vaccineservice.validator;

import com.curelight.vaccineservice.service.ContactService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigurations {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public ContactService getCOntact(){
//        return new ContactService();
//    }
}
