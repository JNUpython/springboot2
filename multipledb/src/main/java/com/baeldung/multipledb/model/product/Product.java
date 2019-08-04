package com.baeldung.multipledb.model.product;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.model.product
 * @Description: TODO
 * @date Date : 2019-08-03 0:27
 */

@Entity
@Table(schema = "products")
@ToString
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
