package com.lairun.common.configuration;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author x_holic@outlook.com
 * @date 2020-01-03
 */
public class RoleBaseVoter implements AccessDecisionVoter<Object> {
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		if (authentication == null) {
			return ACCESS_DENIED;
		}
		int result = ACCESS_ABSTAIN;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (ConfigAttribute attribute : attributes) {
			if (attribute.getAttribute() == null) {
				continue;
			}
			if (this.supports(attribute)) {
				result = ACCESS_DENIED;
				for (GrantedAuthority authority : authorities) {
                    if (authority.getAuthority().equals(attribute.getAttribute())) {
                        return ACCESS_GRANTED;
                    }
				}
			}
		}
		return result;
	}
}
