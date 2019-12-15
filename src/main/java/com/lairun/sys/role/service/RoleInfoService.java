package com.lairun.sys.role.service;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.role.domain.RoleInfo;

/**
 *
 *@author x_holic@outlook.com
 *@date 2019012-13
 */
public interface RoleInfoService {

    PageBean<RoleInfo> queryRoleInfos(PageParam pageParam);

    RoleInfo queryRoleInfo(String roleId);

    void deleteRoleInfo(String roleId);

    void addRoleInfo(RoleInfo roleInfo);

    void editRoleInfo(RoleInfo roleInfo);
}
