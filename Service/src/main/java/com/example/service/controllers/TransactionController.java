package com.example.service.controllers;


import com.example.common.dtos.TransactionDto;
import com.example.common.dtos.request.OperationDto;
import com.example.common.dtos.request.TransactionDateRequest;
import com.example.common.entities.Transaction;
import com.example.service.exception.ServiceException;
import com.example.service.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("transaction")
public class TransactionController extends AbstractController<Transaction, TransactionDto, TransactionService> {


    @PostMapping("/transfer")
    public String doTransaction(@RequestBody OperationDto transactionDto) throws ServiceException {

        return service.resolveTransaction(transactionDto);
    }

    @PostMapping("/betweenDate")
    public List<TransactionDto> getTransactionBetweenDate(@RequestBody TransactionDateRequest transactionDateRequest){

        return adapter.convertEntities(service.getTransactionBetweenDate(transactionDateRequest));
    }

}
