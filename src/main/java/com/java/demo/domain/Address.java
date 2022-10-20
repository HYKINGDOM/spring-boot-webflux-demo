package com.java.demo.domain;


import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("sakila")
public class Address {

    @Column(value = "address_id")
    private Integer addressId;

    private String address;

    private String address2;

    private String district;

    @Column(value = "city_id")
    private Integer cityId;

    @Column(value = "postal_code")
    private String postalCode;

    private String phone;

    @Column(value = "last_update")
    private Date lastUpdate;

}
