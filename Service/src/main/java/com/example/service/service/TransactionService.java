package com.example.service.service;

import com.example.common.dtos.request.OperationDto;
import com.example.common.dtos.request.TransactionDateRequest;
import com.example.common.entities.Account;
import com.example.common.entities.DealType;
import com.example.common.entities.Transaction;
import com.example.service.exception.ServiceException;
import com.example.service.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService extends AbstractService <Transaction, TransactionRepository> {

    @Autowired
    private AccountService accountService;

    public String resolveTransaction(OperationDto operation) throws ServiceException {
        String trackingCode = UUID.randomUUID().toString();
        withdraw(operation,trackingCode);
        deposit(operation,trackingCode);


        return trackingCode;
    }

    public void withdraw(OperationDto operation,String trackingCode) throws ServiceException {
        Account sender = accountService.findById(operation.getSenderAccountId());
        Long senderBalance = sender.getBalance();
        if (senderBalance < operation.getAmount()){
            throw new ServiceException("Balance.low");
        }
        sender.setBalance(senderBalance - operation.getAmount());
        List<Transaction> senderTransactions = sender.getTransactions();
        senderTransactions.add(Transaction
                .builder()
                .transactionDate(new Date())
                .account(sender)
                .amount(operation.getAmount())
                .trackingCode(trackingCode)
                .dealType(DealType.WITHDRAW)
                .build());
        sender.setTransactions(senderTransactions);
        accountService.save(sender);
    }

    public void deposit(OperationDto operation,String trackingCode){
        Account receiver = accountService.findById(operation.getReceiverAccountId());
        receiver.setBalance(receiver.getBalance() + operation.getAmount());
        accountService.save(receiver);

        List<Transaction> receiverTransactions = receiver.getTransactions();
        receiverTransactions.add(Transaction
                .builder()
                .transactionDate(new Date())
                .account(receiver)
                .amount(operation.getAmount())
                .trackingCode(trackingCode)
                .dealType(DealType.DEPOSIT)
                .build());
        receiver.setTransactions(receiverTransactions);
        accountService.save(receiver);

    }
    public List<Transaction> getTransactionBetweenDate(TransactionDateRequest transactionDateRequest) {

        return repository.findByTransactionDateBetween(transactionDateRequest.getFrom(), transactionDateRequest.getTo());
    }

}
