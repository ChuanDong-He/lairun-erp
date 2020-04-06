package com.lairun.sys.role.controller;

import com.lairun.common.domain.PageParam;
import com.lairun.common.utils.ResultUtil;
import com.lairun.sys.role.domain.RolePermission;
import com.lairun.sys.role.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019/12/13
 */
@Validated
@RestController
@RequestMapping("roleInfo")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;

    @PostMapping("queryRoleInfos")
    public Object queryRoleInfos(@RequestBody @Valid PageParam pageParam){
        return ResultUtil.success(roleInfoService.queryRoleInfos(pageParam));
    }

    @GetMapping("queryRoleMenuPermission/{roleId}")
    public Object queryRoleMenuPermission(@PathVariable String roleId){
        return ResultUtil.success(roleInfoService.queryRoleMenuPermission(roleId));
    }

    @PostMapping("saveRolePermission")
    public Object saveRolePermission(@RequestBody @Valid RolePermission rolePermission){
        roleInfoService.saveRolePermission(rolePermission);
        return ResultUtil.success();
    }

    @PostMapping("deleteRoleInfo")
    public Object deleteRoleInfo(@RequestBody @Valid @Size(min = 1, message = "参数错误") List<String> roleIds){
        roleIds.removeIf("admin"::equalsIgnoreCase);
        if (roleIds.size() < 1) {
            return ResultUtil.success();
        }
        roleInfoService.deleteRoleInfo(roleIds);
        return ResultUtil.success();
    }

}
