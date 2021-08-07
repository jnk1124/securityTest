package com.jnk1124.securitytest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<Account>  findAccount(String name){
       Optional<Account> account = accountRepository.findByUsername(name);
       return account;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Account> byName = accountRepository.findByUsername(name);

        Account account = byName.orElseThrow(()-> new UsernameNotFoundException(name));

        return new User(account.getUsername(), account.getPassword(), authority());
    }

    private Collection<? extends GrantedAuthority> authority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Account createAccount(String name, String password) {
        Account account = new Account();

        account.setUsername(name);
        account.setPassword(passwordEncoder.encode(password));

        return accountRepository.save(account);
    }
}
