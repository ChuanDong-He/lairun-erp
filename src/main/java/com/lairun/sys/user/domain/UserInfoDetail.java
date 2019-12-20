package com.lairun.sys.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

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

	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		if (!CollectionUtils.isEmpty(super.getRoles())) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			super.getRoles().forEach(
					roleInfo -> grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleInfo.getRoleId())));
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

	public UserInfo compareToUserInfo() {
		return this;
	}
}
