package com.example.service.controllers;

import com.example.common.dtos.UserDto;
import com.example.common.entities.User;
import com.example.service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserDto, UserService> {
    @Override
    @PostMapping()
    public void save(@RequestBody UserDto userDto) {
        service.save(adapter.convertDto(userDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        service.removeById(id);
    }

    @Override
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return adapter.convertEntity(service.findById(id));
    }

    @Override
    @GetMapping("/")
    public List<UserDto> findAll() {
        return adapter.convertEntities(service.findAll());
    }
}
