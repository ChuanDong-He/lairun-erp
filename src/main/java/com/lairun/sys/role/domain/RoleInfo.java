package com.lairun.sys.role.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lairun.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


/**
 * @author x_holic@outlook.com
 * @date 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleInfo extends BaseEntity {

    private String roleId;

    private String roleName;

    private String roleDesc;

}
