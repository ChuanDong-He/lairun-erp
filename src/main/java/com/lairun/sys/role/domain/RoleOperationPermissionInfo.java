package com.lairun.sys.role.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/6
 */
@Data
@Accessors(chain = true)
public class RoleOperationPermissionInfo {

    private String target;

    private List<OperationInfo> operationInfos;

    private List<Integer> roleOperationPermissionKeys;
}
