package com.lairun.sys.user.service;

import com.lairun.sys.user.domain.UserInfo;
import com.lairun.sys.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
@Service
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoMapper.queryUserInfoByUserId(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userInfo;
    }
}
