package com.lairun.common.aop;

import com.github.pagehelper.PageHelper;
import com.lairun.common.domain.PageParam;
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

	@Before("@annotation(com.lairun.common.annotation.PageHelper)")
	public void pageHelperHandle(JoinPoint joinPoint) {
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof PageParam) {
				PageParam pageParam = (PageParam) arg;
				PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
			}
		}
	}

}
