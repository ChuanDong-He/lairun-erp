package com.lairun.common.advice;

import com.lairun.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-12
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	public Map<String, Object> validException(Exception e) {
		log.error("请求参数异常", e);
		List<String> msg = new ArrayList<>();
		if (e instanceof ConstraintViolationException) {
			((ConstraintViolationException) e).getConstraintViolations()
					.forEach(constraintViolation -> msg.add(constraintViolation.getMessage()));
		}
		return ResultUtil.failure("406", String.join(",", msg));
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> exception(Exception e) {
		log.error("系统异常", e);
		return ResultUtil.failure();
	}

}
