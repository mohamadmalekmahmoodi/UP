package com.example.service.repositories;

import com.example.common.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByTransactionDateBetween(Date From , Date to);
}
