package com.example.service.controllers;

import com.example.common.dtos.AccountDto;
import com.example.common.entities.Account;
import com.example.service.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController extends AbstractController<Account, AccountDto, AccountService> {

}
