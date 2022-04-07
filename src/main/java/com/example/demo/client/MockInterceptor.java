package com.example.demo.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;

@Slf4j
public class MockInterceptor implements RequestInterceptor {
    @Override
    @SneakyThrows
    public void apply(RequestTemplate requestTemplate) {

        requestTemplate.header("Content-Type", ContentType.APPLICATION_JSON.getMimeType());

        requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());

        log.info("REQUEST DTO : {}", requestTemplate);
    }
}
