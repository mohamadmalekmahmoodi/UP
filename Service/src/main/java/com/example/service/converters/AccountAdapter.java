package com.example.service.converters;

import com.example.common.dtos.AccountDto;
import com.example.common.entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountAdapter extends AbstractAdapter<Account, AccountDto>{
}
