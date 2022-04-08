package com.example.demo.Controller;

import com.example.demo.Service.UserServices;
import com.example.demo.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/auth")
public class UserController {
    private final UserServices userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

    public Object openEmas(@RequestBody UserRequest userRequest, BindingResult bindingResult) throws Exception{
        return userService.userService(userRequest);
    }

}
