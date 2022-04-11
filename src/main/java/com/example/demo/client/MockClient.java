package com.example.demo.client;

import com.example.demo.dto.SampleRequest;
import com.example.demo.dto.UserRequest;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="switching-client", url="${mock.url}", configuration = MockConfiguration.class)
public interface MockClient {

    @PostMapping(value ="auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap authentication(@RequestBody SampleRequest sampleRequest) throws Exception;

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap createUser(@RequestBody UserRequest userRequest) throws Exception;
}
