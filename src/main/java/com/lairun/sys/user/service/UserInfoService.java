package com.lairun.sys.user.service;

import com.lairun.sys.user.domain.UserInfoDetail;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
public interface UserInfoService {

    List<UserInfoDetail> queryUserInfos();

}
