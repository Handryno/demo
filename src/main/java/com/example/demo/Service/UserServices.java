package com.example.demo.Service;

import com.example.demo.client.MockClient;
import com.example.demo.dto.UserRequest;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserServices {
        private final MockClient client;
        public Object userService(UserRequest userRequest) throws Exception{
                LinkedTreeMap response = client.createUser(userRequest);
                return response;
        }

}
