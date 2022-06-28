package com.boyu.farmsharing.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boyu.farmsharing.common.BaseResponse;
import com.boyu.farmsharing.common.ResultUtils;
import com.boyu.farmsharing.model.domain.Farmpost;
import com.boyu.farmsharing.model.request.UserPostGetList;
import com.boyu.farmsharing.model.request.UserPostGetRequest;
import com.boyu.farmsharing.model.request.UserPostRequest;
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

        if(StringUtils.isAnyBlank(postTitle,postContent,userName)){
            return ResultUtils.error(PARAMS_ERROR,"参数为空！");
        }

        if(!farmpostService.userPost(postTitle,postContent,userName,postPicture)){
            return ResultUtils.error(PARAMS_ERROR, "参数为空！");
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
     * 获取最新帖子
     * @return 最新的10篇帖子
     */
    @PostMapping("read")
    public BaseResponse userGetList(){
         QueryWrapper wrapper = new QueryWrapper();
         wrapper.orderByDesc("CreateDate");
         wrapper.last("limit 10");
         List<Farmpost> farmpostList = farmpostService.list(wrapper);
         return ResultUtils.success(farmpostList);
    }

    /**
     * 获取点赞最多的帖子
     * @return 10篇点赞最多的帖子
     */
    @PostMapping("love")
    public BaseResponse userGetListLove(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("PostLove");
        wrapper.last("limit 30");
        List<Farmpost> farmpostList = farmpostService.list(wrapper);
        return ResultUtils.success(farmpostList);
    }

    @PostMapping("order")
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

}
