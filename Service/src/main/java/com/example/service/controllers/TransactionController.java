package com.example.service.controllers;


import com.example.common.dtos.TransactionDto;
import com.example.common.entities.Transaction;
import com.example.service.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("transaction")
public class TransactionController extends AbstractController<Transaction, TransactionDto, TransactionService> {

}
