package com.lairun.common.exception;

/**
 * 删除数据异常
 * 
 * @author x_holic@outlook.com
 * @date 2020/4/4
 */
public class DeleteDataException extends RuntimeException {

	public DeleteDataException(String message) {
		super(message);
	}
}
