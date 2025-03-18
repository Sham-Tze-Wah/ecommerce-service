package com.sham.ecommerceservice.serviceimpl;

import com.sham.ecommerceservice.entity.Account;
import com.sham.ecommerceservice.dto.AccountRecord;
import com.sham.ecommerceservice.repository.AccountRepo;
import com.sham.ecommerceservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(AccountRecord accountRecord) {
        Account account = new Account();


        Account savedAccount = accountRepo.save(account);
        log.info("Product {} is saved", savedAccount.getUsername());
        return savedAccount;
    }
}
