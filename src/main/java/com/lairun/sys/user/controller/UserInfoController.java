package com.lairun.sys.user.controller;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.common.utils.ResultUtil;
import com.lairun.common.utils.UserHolder;
import com.lairun.sys.user.domain.ResetPassword;
import com.lairun.sys.user.domain.UserInfo;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
@Validated
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("queryUserInfos")
    public Object queryUserInfos(@RequestBody @Valid PageParam pageParam){
        //int i = 1/0;
        return ResultUtil.success(userInfoService.queryUserInfos(pageParam));
    }

    @PostMapping("addUserInfo")
    public Object addUserInfo(@RequestBody UserInfoDetail userInfoDetail){
        userInfoService.addUserInfo(userInfoDetail);
        return ResultUtil.success();               
    }

    @PostMapping("editUserInfo")
    public Object editUserInfo(@RequestBody UserInfoDetail userInfoDetail){
        userInfoService.editUserInfo(userInfoDetail);
        return ResultUtil.success();
    }

    @PostMapping("deleteUserInfo")
    public Object deleteUserInfo(@RequestBody @Valid @Size(min = 1, message = "参数错误") List<String> userIds){
        userIds.removeIf(UserHolder.getCurrentUserId()::equals);
        if (userIds.size() < 1) {
            ResultUtil.success();
        }
        userInfoService.deleteUserInfo(userIds);
        return ResultUtil.success();
    }

    @GetMapping("queryUserInfo/{userId}")
    public Object queryUserInfo(@PathVariable() String userId){
        return ResultUtil.success(userInfoService.queryUserInfo(userId));
    }

    @GetMapping("checkUserIdExist/{userId}")
    public Object checkUserIdExist(@PathVariable() String userId){
        return ResultUtil.success(userInfoService.checkUserIdExist(userId));
    }

    @GetMapping("getCurrentUser")
    public Object getCurrentUser(){
        return ResultUtil.success(UserHolder.getCurrentUser());
    }

    @PostMapping("resetPassword")
    public Object resetPassword(@RequestBody @Valid ResetPassword resetPassword){
        userInfoService.resetUserPassword(resetPassword);
        return ResultUtil.success();
    }

}
