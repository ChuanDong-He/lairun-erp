package com.lairun.sys.user.mapper;

import com.lairun.common.annotation.PageHelper;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
public interface UserInfoMapper {

    UserInfoDetail queryUserInfoByUserId(@Param("userId") String userId);

    @PageHelper
    List<UserInfo> queryUserInfos(PageParam pageParam);

    int addUserInfo(@Param("userInfo") UserInfoDetail userInfo, @Param("creator") String creator);

    int editUserInfo(@Param("userInfo") UserInfoDetail userInfo, @Param("updatedUser") String updatedUser);

    int deleteUserInfo(@Param("userId") String userId, @Param("updatedUser") String updatedUser);

}
