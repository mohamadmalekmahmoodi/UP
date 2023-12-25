package com.example.service.service;

import com.example.common.dtos.UserDto;
import com.example.common.entities.User;
import com.example.service.repositories.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    @Override
    public User save(User user) {

        return repository.save(user);
    }


    @Cacheable(cacheNames = "USER_CACHE",key = "#id"  )
    @Override
    public User findById(Long id){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    @CacheEvict(cacheNames = "USER_CACHE",key = "#id" )
    public void removeById(Long id){

        repository.deleteById(id);

    }
}
