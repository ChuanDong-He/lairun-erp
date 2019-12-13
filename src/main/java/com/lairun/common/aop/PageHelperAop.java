package com.lairun.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Order(0)
@Component
public class PageHelperAop {

	@Before("within(com.lairun..mapper.*) && @annotation(com.lairun.common.annotation.PageHelper)")
	public void pageHelperHandle(JoinPoint joinPoint) {
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof Map) {
				/*RequestPage<?> requestPage = (RequestPage<?>) arg;
				PageHelper.startPage(requestPage.getPageNum(), requestPage.getPageSize());*/
			}
		}
	}

}
