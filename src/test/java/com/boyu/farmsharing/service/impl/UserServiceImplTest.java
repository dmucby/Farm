package com.boyu.farmsharing.service.impl;

import com.boyu.farmsharing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceImplTest {

    @Resource
    UserService userService;

    @Test
    void testOpenId(){
        String userUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wxd866113b10e95079&secret=7fb368f1c9056d48626633a66625afe2&js_code=0031PeGa1S72sD08IQHa1pDHmt21PeGX&grant_type=authorization_code";
        String openId = userService.userOpenId(userUrl);
        System.out.println(openId);
    }

}
