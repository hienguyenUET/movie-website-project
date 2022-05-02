package com.example.database.repository;

import com.example.database.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Account, Long> {
    Account findByName(String name);
}
