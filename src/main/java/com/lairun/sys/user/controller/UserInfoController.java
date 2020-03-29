package com.lairun.sys.user.controller;

import com.lairun.common.domain.PageParam;
import com.lairun.common.utils.ResultUtil;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
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

    @GetMapping("deleteUserInfo/{userId}")
    public Object deleteUserInfo(@PathVariable() String userId){
        userInfoService.deleteUserInfo(userId);
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

}
