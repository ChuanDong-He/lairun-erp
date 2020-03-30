package com.lairun.sys.user.service.impl;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.domain.UserInfo;
import com.lairun.sys.user.mapper.UserInfoMapper;
import com.lairun.sys.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageBean<UserInfo> queryUserInfos(PageParam pageParam) {
        return new PageBean<>(userInfoMapper.queryUserInfos(pageParam));
    }

    @Override
    public UserInfo queryUserInfo(String userId) {

        UserInfoDetail userInfoDetail = userInfoMapper.queryUserInfoByUserId(userId);

        if (userInfoDetail != null) {
            return userInfoDetail.compareToUserInfo();
        }

        throw new UsernameNotFoundException("用户不存在");
    }

    @Override
    public void addUserInfo(UserInfoDetail userInfo) {
        userInfoMapper.addUserInfo(userInfo, "admin");
    }

    @Override
    public void resetUserPassword(String userId, String password) {

    }

    @Override
    public void editUserInfo(UserInfoDetail userInfo) {
        userInfoMapper.editUserInfo(userInfo, "admin");
    }

    @Override
    public void deleteUserInfo(String ...userIds) {
        userInfoMapper.deleteUserInfo(userIds, "admin");
    }

    @Override
    public boolean checkUserIdExist(String userId) {
        return userInfoMapper.queryUserInfoByUserId(userId) != null;
    }
}
