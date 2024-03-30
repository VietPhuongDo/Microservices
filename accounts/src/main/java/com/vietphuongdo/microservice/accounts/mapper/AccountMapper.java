package com.vietphuongdo.microservice.accounts.mapper;

import com.vietphuongdo.microservice.accounts.dto.AccountDto;
import com.vietphuongdo.microservice.accounts.entity.Account;

public class AccountMapper {

    //mapper from Account object -> Account DTO object
    public static AccountDto mapToAccountDto(Account account,AccountDto accountDto){
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    //mapper from Account DTO object  -> Account object
    public static Account mapToAccount(AccountDto accountDto,Account account){
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
