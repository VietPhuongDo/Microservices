package com.vietphuongdo.microservice.accounts.service.implement;

import com.vietphuongdo.microservice.accounts.constant.AccountConstant;
import com.vietphuongdo.microservice.accounts.dto.CustomerDto;
import com.vietphuongdo.microservice.accounts.entity.Account;
import com.vietphuongdo.microservice.accounts.entity.Customer;
import com.vietphuongdo.microservice.accounts.exception.CustomerAlreadyExistException;
import com.vietphuongdo.microservice.accounts.mapper.CustomerMapper;
import com.vietphuongdo.microservice.accounts.repository.AccountRepository;
import com.vietphuongdo.microservice.accounts.repository.CustomerRepository;
import com.vietphuongdo.microservice.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImplement implements IAccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        //create and save new customer and account to DB
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        //one account only have one mobile number -> check if this number is already exist
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number "
                    +customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    //create a new account from customer information
    private Account createNewAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountConstant.SAVINGS);
        newAccount.setBranchAddress(AccountConstant.ADDRESS);
        newAccount.setCreatedBy("Anonymous");
        newAccount.setCreatedAt(LocalDateTime.now());
        return newAccount;
    }
}
