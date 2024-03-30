package com.vietphuongdo.microservice.accounts.repository;

import com.vietphuongdo.microservice.accounts.entity.Account;
import com.vietphuongdo.microservice.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
