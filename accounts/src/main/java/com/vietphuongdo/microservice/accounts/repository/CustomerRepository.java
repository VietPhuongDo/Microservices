package com.vietphuongdo.microservice.accounts.repository;

import com.vietphuongdo.microservice.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //derived name method(by the findBy + name column in entity, support by jpa)
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
