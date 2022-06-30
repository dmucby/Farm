package com.boyu.farmsharing.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boyu.farmsharing.common.BaseResponse;
import com.boyu.farmsharing.common.ResultUtils;
import com.boyu.farmsharing.mapper.FarmPostMapper;
import com.boyu.farmsharing.model.domain.Farmpost;
import com.boyu.farmsharing.model.request.FarmPost.UserOwnerPostGetList;
import com.boyu.farmsharing.model.request.FarmPost.UserPostGetList;
import com.boyu.farmsharing.model.request.FarmPost.UserPostGetRequest;
import com.boyu.farmsharing.model.request.FarmPost.UserPostRequest;
import com.boyu.farmsharing.model.request.User.UserSearchRequest;
import com.boyu.farmsharing.service.FarmpostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static com.boyu.farmsharing.common.ErrorCode.NULL_ERROR;
import static com.boyu.farmsharing.common.ErrorCode.PARAMS_ERROR;

/**
 * 用户发帖接口
 */
@RequestMapping("/post")
@RestController // 返回Json
public class PostController {

    @Resource
    FarmpostService farmpostService;

    @Resource
    FarmPostMapper farmPostMapper;

    /**
     * 发布帖子
     * @param userPostRequest 帖子参数
     * @return 发帖成功
     */
    @PostMapping("/user")
    public BaseResponse userPost(@RequestBody UserPostRequest userPostRequest){
        if (userPostRequest == null) {
            return ResultUtils.error(NULL_ERROR,"error!");
        }

        String postTitle = userPostRequest.getPostTitle();
        String postContent = userPostRequest.getPostContent();
        String userName = userPostRequest.getUserName();
        String postPicture = userPostRequest.getPostPicture();
        String openId = userPostRequest.getOpenId();

        if(StringUtils.isAnyBlank(postTitle,postContent,userName,openId)){
            return ResultUtils.error(PARAMS_ERROR,"参数为空！");
        }

        if(!farmpostService.userPost(postTitle,postContent,userName,postPicture,openId)){
            return ResultUtils.error(PARAMS_ERROR, "参树不合法！");
        }

        return ResultUtils.success("Post Success!");
    }

    /**
     * 获取帖子
     * @param request 帖子ID
     * @return 一篇帖子
     */
    @PostMapping("/get")
    public BaseResponse userGet(@RequestBody UserPostGetRequest request){
        if (request == null){
            return ResultUtils.error(PARAMS_ERROR, "参数为空！");
        }

        Farmpost farmpost = new Farmpost();
        farmpost = farmpostService.getById(request.getPostID());

        if (farmpost == null) {
            return ResultUtils.error(NULL_ERROR, "请求的数据为空");
        }

        return ResultUtils.success(farmpost);
    }

    /**
     * 按序获取帖子
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/postorder")
    public BaseResponse userGetPostList(@RequestBody UserPostGetList request ){
        if (request == null){
            return ResultUtils.error(PARAMS_ERROR, "参数为空！");
        }

        Integer pageNumber = request.getPageNumber();
        Integer pageNums = request.getPageNums();
        String matchField = request.getMatchField();

        if(pageNumber == 0 || pageNums == 0){
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        if(StringUtils.isAnyBlank(matchField)){
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        List<Farmpost> list = farmpostService.postPage(pageNumber,pageNums,matchField);

        return ResultUtils.success(list);
    }

    /**
     * 模糊匹配查找
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/search")
    public BaseResponse userPostSearch(@RequestBody UserSearchRequest request){
        if (request == null){
            return ResultUtils.error(PARAMS_ERROR, "参数为空！");
        }

        String searchPostTitle = request.getSearchPostTitles();

        if (StringUtils.isEmpty(searchPostTitle)) {
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        QueryWrapper<Farmpost> wrapper = new QueryWrapper<>();

        wrapper.like("PostTitle",searchPostTitle);
        wrapper.last("limit 10");

        return ResultUtils.success(farmPostMapper.selectList(wrapper));
    }

    /**
     * 按序获取用户帖子
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/post")
    public BaseResponse userOwnerGetPostList(@RequestBody UserOwnerPostGetList request ){
        if (request == null){
            return ResultUtils.error(PARAMS_ERROR, "参数为空！");
        }

        Integer pageNumber = request.getPageNumber();
        Integer pageNums = request.getPageNums();
        String openId = request.getOpenId();

        if(pageNumber == 0 || pageNums == 0){
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        if(StringUtils.isAnyBlank(openId)){
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        List<Farmpost> list = farmpostService.postPage(pageNumber,pageNums,openId);

        return ResultUtils.success(list);
    }

}
