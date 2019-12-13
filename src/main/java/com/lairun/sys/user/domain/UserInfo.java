package com.lairun.sys.user.domain;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */
@Data
public class UserInfo implements UserDetails {

    private String userId;

    private String userName;

    private String password;

    private String phoneNumber;

    private String telephoneNumber;

    private String faxNumber;

    private String email;

    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles != null && !roles.isEmpty()) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
            return grantedAuthorities;
        }
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserInfoDetail compareToUserInfoDetail(){
        UserInfoDetail userInfoDetail = new UserInfoDetail();
        BeanUtils.copyProperties(this, userInfoDetail);
        return userInfoDetail;
    }
}
