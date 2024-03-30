package com.vietphuongdo.microservice.accounts.service;

import com.vietphuongdo.microservice.accounts.dto.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
}
