package com.java.demo.service;

import com.java.demo.domain.Account;

import java.util.List;

public interface WebfluxService {


    String getInfo(Long id);


    Account getAccount(Long id);


    List<Account> getAllAccounts();

}
