package com.boyu.farmsharing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyu.farmsharing.model.domain.Farmpost;
import org.apache.ibatis.annotations.Mapper;


/**
* @author 余悸
* @description 针对表【farmpost(帖子)】的数据库操作Mapper
* @createDate 2022-06-13 19:35:51
* @Entity generator.domain.Farmpost
*/
@Mapper
public interface FarmPostMapper extends BaseMapper<Farmpost> {

}




