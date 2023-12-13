package com.example.service.controllers;

import com.example.service.converters.AbstractAdapter;
import com.example.service.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class AbstractController <E,D,S extends AbstractService<E,?>>{

    @Autowired
    protected S service;
    @Autowired
    protected AbstractAdapter<E,D> adapter;


//    @PostMapping("/save")
//    public void save(@RequestBody D dto){
//        service.save(adapter.convertDto(dto));
//
//    }

    @PostMapping(value = "/save")
    public D save(@RequestBody D dto){
        E entity = service.save(adapter.convertDto(dto));
        return adapter.convertEntity(entity);

    }
}
