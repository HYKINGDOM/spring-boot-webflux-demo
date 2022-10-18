package com.java.demo.service;

import cn.hutool.core.util.RandomUtil;
import com.java.demo.domain.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WebfluxServiceImpl implements WebfluxService {

    private static final List<Account> ACCOUNT_ARRAY_LIST = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            ACCOUNT_ARRAY_LIST.add(Account.builder()
                    .accountId(ACCOUNT_ARRAY_LIST.isEmpty() ? 1234567L : RandomUtil.randomLong())
                    .accountName(RandomUtil.randomString(9))
                    .nickname(RandomUtil.randomString(10))
                    .emailAddress(RandomUtil.randomString(10) + "@Gmail.com")
                    .phone(RandomUtil.randomInt(11))
                    .build());
        }
    }


    @Override
    public String getInfo(Long id) {
        return ACCOUNT_ARRAY_LIST.stream().filter(e -> e.getAccountId().equals(1234567L)).collect(Collectors.toList()).toString();
    }

    @Override
    public Account getAccount(Long id) {
        return ACCOUNT_ARRAY_LIST.stream().filter(e -> e.getAccountId().equals(1234567L)).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Account> getAllAccounts() {
        return ACCOUNT_ARRAY_LIST;
    }
}
