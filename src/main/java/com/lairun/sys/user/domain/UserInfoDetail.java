package com.lairun.sys.user.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
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
@Setter
@Getter
@ToString
public class UserInfoDetail extends UserInfo implements UserDetails {

    private String roleId;

    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (StringUtils.isNotBlank(roleId)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleId));
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
        return super.getUserId();
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

    public UserInfo compareToUserInfo(){
        return this;
    }
}
