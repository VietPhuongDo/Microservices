package com.vietphuongdo.microservice.accounts.mapper;

import com.vietphuongdo.microservice.accounts.dto.CustomerDto;
import com.vietphuongdo.microservice.accounts.entity.Customer;

public class CustomerMapper {

    //mapper from Customer object -> Customer DTO object

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    //mapper from Customer DTO object -> Customer object
    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}