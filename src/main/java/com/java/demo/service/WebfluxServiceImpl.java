package com.java.demo.service;

import cn.hutool.core.util.RandomUtil;
import com.java.demo.domain.Account;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
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
//        val duration = Duration.ofMinutes(1);
//        Flux.fromIterable(ACCOUNT_ARRAY_LIST)
//                .mergeWith(Flux.interval(duration))
//                .doOnNext(serviceA::someObserver)
//                .map(d -> d * 2)
//                .take(3)
//                .onErrorResumeWith(errorHandler::fallback)
//                .doAfterTerminate(serviceM::incrementTerminate)
//                .subscribe(System.out::println);


        return ACCOUNT_ARRAY_LIST.stream().filter(e -> e.getAccountId().equals(1234567L)).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Account> getAllAccounts() {
        return ACCOUNT_ARRAY_LIST;
    }
}
