package com.example.demo.client;

import org.springframework.context.annotation.Bean;

public class MockConfiguration {
    @Bean
    public MockDecoder decoder(){return new MockDecoder();}

    @Bean
    public MockInterceptor interceptor(){return new MockInterceptor();}
}
