package com.example.service.repositories;

import com.example.common.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
