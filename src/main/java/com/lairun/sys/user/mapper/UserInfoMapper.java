package com.lairun.sys.user.mapper;

import com.lairun.sys.user.domain.UserInfo;
import com.lairun.sys.user.domain.UserInfoDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
public interface UserInfoMapper {

    UserInfo queryUserInfoByUserId(@Param("userId") String userId);

    List<UserInfoDetail> queryUserInfos();

}
