package com.sk.testmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
       return security.authorizeHttpRequests(httpRequest ->
                httpRequest.requestMatchers("/api/customers").permitAll()
                .anyRequest().authenticated()).formLogin(form -> form.permitAll()).build();
    }
}
