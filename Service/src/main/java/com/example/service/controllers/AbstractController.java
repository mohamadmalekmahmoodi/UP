package com.example.service.controllers;

import com.example.common.validations.GeneralValidationGroup;
import com.example.common.validations.NotNullGroup;
import com.example.service.converters.AbstractAdapter;
import com.example.service.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


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

    @PostMapping()
    public void add(@RequestBody @Validated({NotNullGroup.class, GeneralValidationGroup.class}) D d)  {
        service.save(adapter.convertDto(d));
    }
}
