package com.example.common.dtos;

import com.example.common.entities.Account;
import com.example.common.entities.DealType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class TransactionDto {

    private Long id;
    private Date transactionDate;
    private Account account;
    private Long amount;
    private DealType dealType;
    private String trackingCode;
}
