package chapter4.aspect.validator.impl;


import chapter3.pojo.User;
import chapter4.aspect.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user != null;
    }

}
