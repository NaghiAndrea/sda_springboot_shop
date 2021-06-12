package com.sda.andreanaghi.webshop.repository;

import com.sda.andreanaghi.webshop.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    /*
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAll(){
        return accounts;
    }

    public void save(Account account){
        accounts.add(account);
    }
     */

    List<Account> findAllByIsClosed(Boolean isClosed);

    List<Account> findAllByBillingAddress(String city);

    List<Account> findAllByCreationDateBetween(Date startDate, Date endDate);

    List<Account> findAllByBillingAddressContaining(String city);
}
