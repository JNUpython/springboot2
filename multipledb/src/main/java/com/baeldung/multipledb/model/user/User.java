package com.baeldung.multipledb.model.user;

import lombok.ToString;

import javax.persistence.*;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.model.user
 * @Description: TODO
 * @date Date : 2019-08-03 0:23
 */

@Entity
@Table(schema = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}
