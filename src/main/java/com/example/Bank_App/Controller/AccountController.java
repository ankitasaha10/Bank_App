package com.example.Bank_App.Controller;

import com.example.Bank_App.Model.Account;
import com.example.Bank_App.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        Account existingAccount = accountRepository.findByAccountId(account.getAccountId());
        if (existingAccount != null) {
            return ResponseEntity.badRequest().body("Account already exists.");
        }

        accountRepository.save(account);
        return ResponseEntity.ok("Account created successfully.");
    }
}
