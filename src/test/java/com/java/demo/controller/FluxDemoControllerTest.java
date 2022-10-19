package com.java.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.java.demo.domain.Account;
import com.java.demo.service.WebfluxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = FluxDemoController.class)
class FluxDemoControllerTest {


    @MockBean
    private WebfluxService webfluxService;

    @Autowired
    WebTestClient client;

    @Test
    public void getAllMessagesShouldBeOk() {

        Account account = Account.builder()
                .accountId(RandomUtil.randomLong())
                .accountName(RandomUtil.randomString(9))
                .nickname(RandomUtil.randomString(10))
                .emailAddress(RandomUtil.randomString(10) + "@Gmail.com")
                .phone(RandomUtil.randomInt(11))
                .build();

        Mockito.when(webfluxService.getAccount(Mockito.any())).thenReturn(account);
        client.get()
                .uri("/api/flux/getAccount")
                .exchange()
                .expectStatus()
                .isOk();
    }


}