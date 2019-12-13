package com.lairun.sys.user.service.impl;

import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.mapper.UserInfoMapper;
import com.lairun.sys.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoDetail> queryUserInfos() {
        return userInfoMapper.queryUserInfos();
    }
}
