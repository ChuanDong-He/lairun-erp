package com.lairun.common.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
@Data
public class PageParam {

	@NotNull(message = "pageNum 不能为空")
	@Min(value = 1L, message = "pageNum不能小于1")
	private Integer pageNum;

	@NotNull(message = "pageNum 不能为空")
	@Range(min = 1L, max = 100L, message = "pageSize范围在1-100之间")
	private Integer pageSize;

	/**
	 * 分页查询条件
	 */
	private Map<String, Object> param;

	public Map<String, Object> getParam() {
		return Optional.ofNullable(param).orElse(new HashMap<>());
	}
}
