package com.baeldung.multipledb.dao.user;

import com.baeldung.multipledb.model.product.Product;
import com.baeldung.multipledb.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.dao.user
 * @Description: TODO
 * @date Date : 2019-08-03 0:41
 */
@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
    public User selectOneById(@Param("id") int id);
}
