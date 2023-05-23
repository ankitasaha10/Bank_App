package com.example.Bank_App.Controller;

import com.example.Bank_App.Model.Transaction;
import com.example.Bank_App.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestBody Transaction transaction) {
        transactionService.credit(transaction.getUserId(), transaction.getAccountId(), transaction.getAmount());
        return ResponseEntity.ok("Credit operation successful.");
    }

    @PostMapping("/debit")
    public ResponseEntity<String> debit(@RequestBody Transaction transaction) {
        transactionService.debit(transaction.getUserId(), transaction.getAccountId(), transaction.getAmount());
        return ResponseEntity.ok("Debit operation successful.");
    }
}
