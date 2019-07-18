package com.ssm.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.ssm.demo.entity
 * @Description: TODO
 * @date Date : 2019-07-18 22:33
 */

@Data
//@AllArgsConstructor
//@RequiredArgsConstructor
public class Customer {
    
    private Integer id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String  gender;

    @NonNull
    private String telephone;

    @NonNull
    private String address;

    public Customer() {
    }

    public Customer(@NonNull String name, @NonNull String gender, @NonNull String telephone, @NonNull String address) {
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.address = address;
    }

}
