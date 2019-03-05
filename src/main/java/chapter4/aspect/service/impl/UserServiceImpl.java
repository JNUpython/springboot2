package chapter4.aspect.service.impl;

import chapter3.pojo.User;
import chapter4.aspect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter4.aspect.service
 * @Description: TODO
 * @date Date : 2019-03-04 23:03
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {
        if (null == user) {
            throw new RuntimeException("user is null");
        }
        // log.info("{}", user);
    }
}
