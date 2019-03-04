package chapter4.aspect.controller;

import chapter3.pojo.User;
import chapter4.aspect.service.UserService;
import chapter4.aspect.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter4.aspect.controller
 * @Description: TODO
 * @date Date : 2019-03-04 23:34
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl = null;

    @RequestMapping("/print")
    @ResponseBody
    private User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setNote(note);
        user.setId(id);
        user.setUserName(userName);
        userServiceImpl.printUser(user);
        return user;
    }
}
