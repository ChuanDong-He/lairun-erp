package com.lairun.sys.role.mapper;

import com.lairun.common.annotation.PageHelper;
import com.lairun.common.domain.PageParam;
import com.lairun.sys.role.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author x_holic@outlook.com
 * @date 2019/12/13
 */
public interface RoleInfoMapper {

	@PageHelper
	List<RoleInfo> queryRoleInfos(PageParam pageParam);

	int deleteRoleInfo(@Param("roleIds") List<String> roleIds, @Param("updatedUser") String updatedUser);

	List<String> isAssociatedRoleName(@Param("roleIds") List<String> roleIds);

	List<MenuTreeInfo> queryMenuInfo();

	List<Integer> queryRoleMenuPermissionKey(@Param("roleId") String roleId);

	int saveRolePermission(@Param("rolePermission") RolePermission rolePermission);

	List<AttrInfo> queryAttrInfo(@Param("target") String target);

	List<OperationInfo> queryOperationInfo(@Param("target") String target);

	List<Integer> queryRoleAttrPermissionKey(@Param("target") String target, @Param("roleId") String roleId);

	List<Integer> queryRoleOperationPermissionKey(@Param("target") String target, @Param("roleId") String roleId);

	List<String> queryRoleAttrTarget();

	List<String> queryRoleOperationTarget();

}
