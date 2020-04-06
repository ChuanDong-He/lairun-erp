package com.lairun.sys.dept.domain;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author x_holic@outlook.com
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeptInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer deptId;

    private String deptName;

    private Integer upDeptId;

}
