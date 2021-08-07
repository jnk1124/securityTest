package com.jnk1124.securitytest;

import com.jnk1124.securitytest.account.Account;
import com.jnk1124.securitytest.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account jnk1124 = accountService.createAccount("jnk1124", "1234");

        System.out.println("jnk1124.getPassword() = " + jnk1124.getPassword());
    }
}
