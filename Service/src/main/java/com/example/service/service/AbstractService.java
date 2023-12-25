package com.example.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService<E,R extends JpaRepository<E,Long>> {
    @Autowired
    protected R repository;

    public E save(E entity){
        return repository.save(entity);
    }

    public void removeById(Long id){
        this.repository.deleteById(id);
    }

    public E findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("wrong"));
    }

    public List<E> findAll(){
        return repository.findAll();
    }

    public List<E> findBySample(E entity){
        return repository.findAll(Example.of(entity));
    }
}
