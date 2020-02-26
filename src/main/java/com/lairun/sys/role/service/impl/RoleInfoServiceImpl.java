package com.lairun.sys.role.service.impl;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.role.domain.RoleInfo;
import com.lairun.sys.role.mapper.RoleInfoMapper;
import com.lairun.sys.role.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author x_holic@outlook.com
 * @date 2019/12/13
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public PageBean<RoleInfo> queryRoleInfos(PageParam pageParam) {
        return new PageBean<>(roleInfoMapper.queryRoleInfos(pageParam));
    }

    @Override
    public RoleInfo queryRoleInfo(String roleId) {
        return null;
    }

    @Override
    public void deleteRoleInfo(String roleId) {

    }

    @Override
    public void addRoleInfo(RoleInfo roleInfo) {

    }

    @Override
    public void editRoleInfo(RoleInfo roleInfo) {

    }
}
