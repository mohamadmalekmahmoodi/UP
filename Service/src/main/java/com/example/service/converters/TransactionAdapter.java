package com.example.service.converters;

import com.example.common.dtos.TransactionDto;
import com.example.common.entities.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionAdapter extends AbstractAdapter<Transaction, TransactionDto>{

}
