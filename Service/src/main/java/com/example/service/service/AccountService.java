package com.example.service.service;

import com.example.common.entities.Account;
import com.example.service.repositories.AccountRepository;
import org.springframework.stereotype.Service;


@Service
public class AccountService extends AbstractService<Account, AccountRepository> {
}
