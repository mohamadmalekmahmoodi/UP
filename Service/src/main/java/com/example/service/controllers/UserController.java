package com.example.service.controllers;

import com.example.common.dtos.UserDto;
import com.example.common.entities.User;
import com.example.service.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserDto, UserService> {
    @Override
    @PostMapping("/insert")
    public void add(@RequestBody UserDto user){
        service.save(adapter.convertDto(user));
    }
}
