package com.lairun.common.utils;

import com.lairun.common.advice.exception.UserNotLoginException;
import com.lairun.sys.user.domain.UserInfo;
import com.lairun.sys.user.domain.UserInfoDetail;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHolder {

	public static UserInfo getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserInfoDetail) {
			return ((UserInfoDetail) principal);
		}
		throw new UserNotLoginException("用户未登录");
	}

	public static String getCurrentUserId() {
		return getCurrentUser().getUserId();
	}

}
