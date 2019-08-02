package com.baeldung.multipledb.dao.product;

import com.baeldung.multipledb.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.dao.product
 * @Description: TODO
 * @date Date : 2019-08-03 0:43
 */
@Service
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products WHERE id = :id", nativeQuery = true)
    public Product selectOneById(@Param("id") int id);

}
