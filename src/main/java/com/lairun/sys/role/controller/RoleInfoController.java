package com.lairun.sys.role.controller;

import com.lairun.common.domain.PageParam;
import com.lairun.common.utils.ResultUtil;
import com.lairun.sys.role.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author x_holic@outlook.com
 * @date 2019/12/13
 */
@RestController
@RequestMapping("roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    @PostMapping("queryRoleInfos")
    public Object queryRoleInfos(@RequestBody @Valid PageParam pageParam){
        return ResultUtil.success(roleInfoService.queryRoleInfos(pageParam));
    }

}
