package com.example.Bank_App.Service;

import com.example.Bank_App.Model.Account;
import com.example.Bank_App.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void credit(String userId, String accountId, double amount) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            if (newBalance <= 10000000) {
                account.setBalance(newBalance);
                accountRepository.save(account);
            } else {
                throw new RuntimeException("Account balance cannot exceed 10 million.");
            }
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
    @Override
    @Transactional
    public void debit(String userId, String accountId, double amount) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account != null) {
            double newBalance = account.getBalance() - amount;
            if (newBalance >= 0) {
                account.setBalance(newBalance);
                accountRepository.save(account);
            } else {
                throw new RuntimeException("Account balance cannot go below 0.");
            }
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
}
