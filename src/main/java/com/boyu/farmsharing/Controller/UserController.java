package com.boyu.farmsharing.Controller;


import com.boyu.farmsharing.common.BaseResponse;
import com.boyu.farmsharing.common.ResultUtils;
import com.boyu.farmsharing.mapper.UserMapper;
import com.boyu.farmsharing.model.domain.User;
import com.boyu.farmsharing.model.request.User.*;
import com.boyu.farmsharing.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


import java.util.Date;

import static com.boyu.farmsharing.common.ErrorCode.*;

/**
 * 用户接口
 */
@RequestMapping("/user")
@RestController // 返回Json
public class UserController {

    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    /**
     * 将用户信息存入数据库
     * @param userSaveRequest 请求参数
     * @return 请求或失败
     */
    @PostMapping("/save")
    public BaseResponse userSave(@RequestBody UserSaveRequest userSaveRequest){
        if (userService.requestIsNull(userSaveRequest)){
            return ResultUtils.error(NULL_ERROR, "参数为空！");
        }

        String userName = userSaveRequest.getUserName();
        String avatarUrl = userSaveRequest.getAvatarUrl();
        String openId = userSaveRequest.getOpenId();


        if(StringUtils.isAnyBlank(userName,avatarUrl,openId)){
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        if (!userService.userSave(openId,userName,avatarUrl)){
            return ResultUtils.error(SYSTEM_ERROR, "系统异常");
        }

        return ResultUtils.success("用户信息存入成功！");
    }

    /**
     * 根据用户Id获取用户信息
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/get")
    public BaseResponse userGetInformation(@RequestBody UserGetRequest request){
        if(userService.requestIsNull(request)){
            return ResultUtils.error(NULL_ERROR, "参数为空！");
        }

        String openId = request.getOpenId();

        if (openId == null) {
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        User user = userService.getById(openId);

        return ResultUtils.success(userService.cleanUser(user));
    }

    /**
     * 更新用户昵称或者用户头像
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/update")
    public BaseResponse userUpdateInformation(@RequestBody UserUpdateRequest request) {
        if (userService.requestIsNull(request)) {
            return ResultUtils.error(NULL_ERROR, "参数为空！");
        }

        String stringKey = request.getStringKey();
        String stringValue = request.getStringValue();
        String openId = request.getOpenId();

        if (openId == null) {
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        if (StringUtils.isAnyBlank(stringKey, stringValue)) {
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        User user = userService.getById(openId);
        user.setUpdateTime(new Date());

        if (stringKey.equals("username")) {
            user.setUsername(stringValue);
        } else {
            user.setAvatarUrl(stringValue);
        }
        if (userMapper.updateById(user) < 1) {
            return ResultUtils.error(SYSTEM_ERROR, "系统异常");
        }

        return ResultUtils.success("update ok!");
    }

    /**
     * 获取用户OpenId
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/openid")
    public BaseResponse userGetOpenId(@RequestBody UserOpenIdRequest request){
        if (userService.requestIsNull(request)) {
            return ResultUtils.error(NULL_ERROR, "参数为空！");
        }

        String code = request.getUserUrl();

        
        String openId = userService.userOpenId(code);

        return ResultUtils.success(openId);
    }

    /**
     * 检查用户是否登录
     * @param request 请求参数
     * @return 请求结果
     */
    @PostMapping("/admin")
    public BaseResponse userIsAdmin(@RequestBody UserAdminRequest request) {
        if (userService.requestIsNull(request)) {
            return ResultUtils.error(NULL_ERROR, "参数为空！");
        }

        String openId = request.getOpenId();

        if (openId == null) {
            return ResultUtils.error(PARAMS_ERROR, "请正确书写请求参数");
        }

        if (!userService.userIsSave(openId)) {
            return ResultUtils.error(NOT_LOGIN, "该用户未登录");
        }

        return ResultUtils.success("user is saved!");
    }



}
