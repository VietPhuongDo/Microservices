package com.vietphuongdo.microservice.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class AccountDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
