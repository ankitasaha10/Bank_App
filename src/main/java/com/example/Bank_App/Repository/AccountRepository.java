package com.example.Bank_App.Repository;

import com.example.Bank_App.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByAccountId(String accountId);
}
