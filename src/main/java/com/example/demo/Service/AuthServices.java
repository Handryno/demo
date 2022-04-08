package com.example.demo.Service;

import com.example.demo.client.MockClient;
import com.example.demo.dto.SampleRequest;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthServices {
    private final MockClient client;
    public Object authService(SampleRequest sampleRequest) throws Exception{
        LinkedTreeMap response = client.authentication(sampleRequest);
        return response;
    }
}
