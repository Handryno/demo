package com.example.demo.Controller;

import com.example.demo.Service.AuthServices;
import com.example.demo.dto.SampleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthContorller {
    private final AuthServices authServices;

    @RequestMapping(value="/login",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object openTabunganEmas(@RequestBody SampleRequest sampleRequest, BindingResult result) throws Exception{
        return authServices.authService(sampleRequest);
    }
}
