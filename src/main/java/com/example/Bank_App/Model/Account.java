package com.example.Bank_App.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "account_id")
    private String accountId;

    private double balance;
}

