package com.example.demo.repositories;

import com.example.demo.models.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {
}
