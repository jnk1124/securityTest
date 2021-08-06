package com.jnk1124.securitytest.account;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Account {

    @Id @Generated
    private Long id;
    private String username;
    private String password;

}
