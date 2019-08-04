package com.kean.mybatis.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.mybatis.bean
 * @Description: TODO
 * @date Date : 2019-06-10 20:39
 */

@Data
@ToString
public class Boss {
    int id;
    String name;
    int companyId;
    String sex;
}
