package com.lairun.sys.user.service;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.domain.UserInfo;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
public interface UserInfoService {

    PageBean<UserInfo> queryUserInfos(PageParam pageParam);

    UserInfo queryUserInfo(String userId);

    void addUserInfo(UserInfoDetail userInfoDetail);

    void resetUserPassword(String userId, String password);

    void editUserInfo(UserInfoDetail userInfo);

    void deleteUserInfo(List<String> userIds);

    boolean checkUserIdExist(String userId);

}
