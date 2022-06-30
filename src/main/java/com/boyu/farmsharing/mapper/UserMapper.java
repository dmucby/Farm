package com.boyu.farmsharing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyu.farmsharing.model.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
* @author 余悸
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2022-06-29 21:38:37
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




