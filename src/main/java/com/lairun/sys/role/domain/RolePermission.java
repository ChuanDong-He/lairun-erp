package com.lairun.sys.role.domain;

import com.lairun.common.annotation.AdminRoleValid;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/6
 */
@Data
public class RolePermission {

    @NotBlank(message = "角色ID不能为空")
    @AdminRoleValid(message = "系统管理员角色无需配置权限")
    private String roleId;

    @NotNull(message = "菜单权限不能为空")
    @Size(min = 1, message = "菜单权限不能为空")
    private List<Integer> menuPermission;

}
