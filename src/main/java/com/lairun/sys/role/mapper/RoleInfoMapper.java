package com.lairun.sys.role.mapper;

import com.lairun.common.annotation.PageHelper;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.role.domain.RoleInfo;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019/12/13
 */
public interface RoleInfoMapper {

    @PageHelper
    List<RoleInfo> queryRoleInfos(PageParam pageParam);

}
