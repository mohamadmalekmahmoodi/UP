package com.example.service.service;

import com.example.common.entities.User;
import com.example.service.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    @Override
    public User save(User entity) {
        return super.save(entity);
    }
}
