package com.example.Bank_App.Service;

public interface TransactionService {
    void credit(String userId, String accountId, double amount);

    void debit(String userId, String accountId, double amount);
}
