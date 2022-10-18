package com.java.demo.controller;


import com.java.demo.domain.Account;
import com.java.demo.service.WebfluxService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/flux")
public class FluxDemoController {

    private final WebfluxService webfluxService;


    @GetMapping("/info")
    public Flux<String> getInfo() {
        return Flux.just(webfluxService.getInfo(1234567L));
    }


    @GetMapping("/getAccount")
    public Flux<Account> getAccount() {
        return Flux.just(webfluxService.getAccount(1234567L));
    }

    @GetMapping("/getAllAccounts")
    public Flux<List<Account>> getAllAccounts() {
        return Flux.just(webfluxService.getAllAccounts());
    }

}
