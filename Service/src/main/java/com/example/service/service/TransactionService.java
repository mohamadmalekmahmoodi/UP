package com.example.service.service;

import com.example.common.entities.Transaction;
import com.example.service.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends AbstractService <Transaction, TransactionRepository> {
}
