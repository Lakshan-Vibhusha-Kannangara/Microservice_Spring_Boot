package com.vibhusha.config;


import com.vibhusha.client.BlogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;


    @Bean

    public WebClient blogWebClient() {
        return WebClient.builder()
                .baseUrl("http://blog-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public BlogClient blogClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(blogWebClient())).build();
        return httpServiceProxyFactory.createClient(BlogClient.class);
    }


}
