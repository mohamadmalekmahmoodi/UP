package com.example.service.controllers;

import com.example.common.dtos.AccountDto;
import com.example.common.dtos.CardDto;
import com.example.common.entities.Account;
import com.example.service.converters.CardAdapter;
import com.example.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<Account, AccountDto, AccountService> {
    @Autowired
    CardAdapter cardAdapter;



    @PostMapping("/addCard/{id}")
    public void addCardToAccount(@RequestBody @Validated CardDto cardDto, @PathVariable Long id) {

        service.addCartToAccount(cardAdapter.convertDto(cardDto), id);

    }
}
