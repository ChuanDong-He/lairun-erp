package com.lairun.sys.user.controller;

import com.lairun.common.utils.ResponseResultUtil;
import com.lairun.sys.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object queryUserInfos(){
        return ResponseResultUtil.success(userInfoService.queryUserInfos());
    }

}
