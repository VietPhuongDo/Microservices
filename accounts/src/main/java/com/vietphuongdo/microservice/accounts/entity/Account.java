package com.vietphuongdo.microservice.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
@Table(name = "accounts")
public class Account extends BaseEntity{
    @Column(name = "customer_id")
    private Long customerId;
    @Id
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
}
