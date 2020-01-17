package com.lairun.sys.role.domain;

import lombok.Data;

/**
 * @author x_holic@outlook.com
 * @date 2020-01-16
 */
@Data
public class PermissionInfo {

    private Integer permissionId;

    private String permissionName;

    private String permissionCode;

    private Integer upPermissionId;

    private String type;

    private String url;

    private Integer order;

}
