package com.lairun.common.advice;

import com.lairun.common.exception.DeleteDataException;
import com.lairun.common.exception.UserNotFoundException;
import com.lairun.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

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

	@ExceptionHandler(value = { ConstraintViolationException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	public Map<String, Object> validException(Exception e) {
		log.error("请求参数异常", e);
		List<String> msg = new ArrayList<>();
		if (e instanceof ConstraintViolationException) {
			((ConstraintViolationException) e).getConstraintViolations()
					.forEach(constraintViolation -> msg.add(constraintViolation.getMessage()));
		} else if (e instanceof MethodArgumentNotValidException) {
			((MethodArgumentNotValidException) e).getBindingResult().getAllErrors()
					.forEach(objectError -> msg.add(objectError.getDefaultMessage()));
		} else if (e instanceof HttpMessageNotReadableException) {
			return ResultUtil.failure("406", "请求参数错误");
		}

		return ResultUtil.failure("406", String.join(",", msg));
	}

	@ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> notFoundException() {
		return ResultUtil.failure("404", "请求资源不存在");
	}

	@ExceptionHandler(value = { HttpMediaTypeNotSupportedException.class })
	@ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public Map<String, Object> httpMediaTypeNotSupportedException() {
		return ResultUtil.failure("415", "不支持的媒体类型");
	}

	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	public Map<String, Object> httpRequestMethodNotSupportedException() {
		return ResultUtil.failure("405", "请求方法错误");
	}

	@ExceptionHandler(value = { UserNotFoundException.class })
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public Map<String, Object> userNotLoginException() {
		return ResultUtil.failure("401", "用户未登录");
	}

	@ExceptionHandler(value = { DeleteDataException.class })
	@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
	public Map<String, Object> deleteDataException(DeleteDataException e) {
		return ResultUtil.failure("412", e.getMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> exception(Exception e) {
		log.error("系统异常", e);
		return ResultUtil.failure();
	}

}
