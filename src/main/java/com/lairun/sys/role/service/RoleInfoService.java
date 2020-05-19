package com.lairun.sys.role.service;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.role.domain.*;

import java.util.List;

/**
 *
 *@author x_holic@outlook.com
 *@date 2019012-13
 */
public interface RoleInfoService {

    PageBean<RoleInfo> queryRoleInfos(PageParam pageParam);

    List<RoleInfo> queryAllRoleInfos();

    RoleInfo queryRoleInfo(String roleId);

    void deleteRoleInfo(List<String> roleIds);

    void addRoleInfo(RoleInfo roleInfo);

    void editRoleInfo(RoleInfo roleInfo);

    RoleMenuPermissionInfo queryRoleMenuPermission(String roleId);

    void saveRolePermission(RolePermission rolePermission);

    List<RoleAttrPermissionInfo> queryRoleAttrPermission(String roleId);

    List<RoleOperationPermissionInfo> queryRoleOperationPermission(String roleId);
}
