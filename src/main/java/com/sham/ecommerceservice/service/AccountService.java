package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.entity.Account;
import com.sham.ecommerceservice.dto.AccountRecord;

public interface AccountService {
    public Account createAccount(AccountRecord accountRecord);
}
