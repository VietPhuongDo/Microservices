package com.vietphuongdo.microservice.accounts.controller;

import com.vietphuongdo.microservice.accounts.constant.AccountConstant;
import com.vietphuongdo.microservice.accounts.dto.CustomerDto;
import com.vietphuongdo.microservice.accounts.dto.ResponseDto;
import com.vietphuongdo.microservice.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {
    private IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,AccountConstant.MESSAGE_201));
    }
}
