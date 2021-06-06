package com.sda.andreanaghi.webshop.service;

import com.sda.andreanaghi.webshop.model.Account;
import com.sda.andreanaghi.webshop.model.Customer;
import com.sda.andreanaghi.webshop.repository.AccountRepository;
import com.sda.andreanaghi.webshop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    // Injected by Spring by constructor
    public CustomerService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void addCustomer(Account account, Customer customer){
        accountRepository.save(account);
        customerRepository.save(customer);
    }

//    public List<Account> getCustomerAccounts(){//
//        return accountRepository.getAll();
//    }

    public Iterable<Account> getCustomerAccounts(){
        return accountRepository.findAll();
    }


}
