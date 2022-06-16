package com.boyu.farmsharing.service.impl;

import com.boyu.farmsharing.service.FarmpostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class FarmpostServiceImplTest {

    @Resource
    private FarmpostService farmpostService;

//    @Test
//    void userPostTest(){
//
//        String postTitle = "农场";
//        String postContent = "农场";
//        String userName = "农场";
//        String postPicture = "农场";
//
//        Boolean bool = farmpostService.userPost(postTitle, postContent, userName, postPicture);
//
//        Assertions.assertEquals(true,bool);
//    }

}