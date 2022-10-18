package com.java.demo.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private Long accountId;

    private String accountName;

    private String nickname;

    private String emailAddress;

    private Integer phone;

}
