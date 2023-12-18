package com.example.service.service;

import com.example.common.entities.Account;
import com.example.common.entities.Card;
import com.example.service.exception.ServiceException;
import com.example.service.repositories.AccountRepository;
import org.springframework.stereotype.Service;


@Service
public class AccountService extends AbstractService<Account, AccountRepository> {
    public void addCartToAccount(Card card , Long userId) {


            Account userAccount = repository.findByUser_Id(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
            userAccount.setCard(card);

            repository.save(userAccount);

        }
    }