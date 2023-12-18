package com.example.common.dtos;

import com.example.common.entities.Account;
import com.example.common.entities.DealType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {

    private Date transactionDate;
    private Long amount;
    private DealType dealType;
    private String trackingCode;
}
