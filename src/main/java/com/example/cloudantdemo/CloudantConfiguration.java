package com.example.cloudantdemo;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudantConfiguration {

    @Value("${VCAP_SERVICES}")
    private String vcapService;

    @Bean
    public CloudantClient cloudantClient()  {
        return ClientBuilder.bluemix(vcapService).build();
    }

}
