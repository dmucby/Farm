package com.boyu.farmsharing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.boyu.farmsharing.mapper.UserMapper;
import com.boyu.farmsharing.model.domain.User;
import com.boyu.farmsharing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
* @author 余悸
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-06-29 21:38:37
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    UserMapper userMapper;

    @Bean
    RestTemplate Template(){
        return new RestTemplate();
    }

    @Override
    public boolean userSave(String openId, String username, String avatarUrl) {

        if(StringUtils.isAnyBlank(username,avatarUrl,openId)){
            return false;
        }

        User user = new User();
        user.setOpenId(openId);
        user.setAvatarUrl(avatarUrl);
        user.setUsername(username);

        this.save(user);

        return true;
    }

    @Override
    public String userOpenId(String openIdUrl) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(openIdUrl, HttpMethod.GET, null, String.class);
        return responseEntity.getBody();
    }

    @Override
    public boolean requestIsNull(Object request) {
        return request == null;
    }

    @Override
    public User cleanUser(User user) {
        User cleanUser = new User();
        cleanUser.setAvatarUrl(user.getAvatarUrl());
        cleanUser.setUsername(user.getUsername());
        cleanUser.setOpenId(null);
        cleanUser.setUpdateTime(user.getUpdateTime());
        cleanUser.setCreateTime(user.getCreateTime());
        return cleanUser;
    }

    @Override
    public boolean userIsSave(String openId) {
        if (StringUtils.isBlank(openId)){
            return false;
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("openId",openId);

        User user = userMapper.selectOne(wrapper);

        if (user == null){
            log.info("user is null,please input the right openId");
            return false;
        }

        return true;

    }

    @Override
    public boolean userIsLogin(String openId) {
        if (StringUtils.isBlank(openId)){
            return false;
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("openId",openId);

        User user = userMapper.selectOne(wrapper);

        return user != null;
    }

}




