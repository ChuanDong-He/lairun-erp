package com.lairun.sys.role.service.impl;

import com.lairun.common.domain.PageBean;
import com.lairun.common.domain.PageParam;
import com.lairun.common.exception.DeleteDataException;
import com.lairun.common.utils.UserHolder;
import com.lairun.sys.role.domain.*;
import com.lairun.sys.role.mapper.RoleInfoMapper;
import com.lairun.sys.role.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
	public List<RoleInfo> queryAllRoleInfos() {
		return roleInfoMapper.queryAllRoleInfos();
	}

	@Override
	public RoleInfo queryRoleInfo(String roleId) {
		return null;
	}

	@Override
	public void deleteRoleInfo(List<String> roleIds) {
		List<String> roleNames = roleInfoMapper.isAssociatedRoleName(roleIds);
		if (roleNames.size() > 0) {
			throw new DeleteDataException("《" + String.join("、", roleNames) + "》已被用户使用");
		}
		roleInfoMapper.deleteRoleInfo(roleIds, UserHolder.getCurrentUserId());
	}

	@Override
	public void addRoleInfo(RoleInfo roleInfo) {

	}

	@Override
	public void editRoleInfo(RoleInfo roleInfo) {

	}

	@Override
	public RoleMenuPermissionInfo queryRoleMenuPermission(String roleId) {
		List<MenuTreeInfo> menuTreeInfos = roleInfoMapper.queryMenuInfo();
		List<MenuTreeInfo> treeMenuTreeInfos = new ArrayList<>();
		menuTreeInfos.forEach(menuTreeInfo -> {
			if (0 == menuTreeInfo.getUpKey()) {
				treeMenuTreeInfos.add(menuTreeInfo);
				menuTreeInfo.setChildren(treeMenu(menuTreeInfos, menuTreeInfo));
			}
		});
		return new RoleMenuPermissionInfo().setMenuTreeInfos(treeMenuTreeInfos)
				.setRoleMenuPermissionKeys(roleInfoMapper.queryRoleMenuPermissionKey(roleId));
	}

	@Override
	public void saveRolePermission(RolePermission rolePermission) {
		roleInfoMapper.saveRolePermission(rolePermission);
	}

	private List<MenuTreeInfo> treeMenu(List<MenuTreeInfo> menuTreeInfos, MenuTreeInfo upNode) {
		if (menuTreeInfos == null || menuTreeInfos.size() < 1) {
			return menuTreeInfos;
		}
		List<MenuTreeInfo> children = new ArrayList<>();
		menuTreeInfos.forEach(menuTreeInfo -> {
			if (upNode.getKey().equals(menuTreeInfo.getUpKey())) {
				children.add(menuTreeInfo);
				treeMenu(menuTreeInfos, menuTreeInfo);
			}
		});
		return children;
	}

	@Override
	public List<RoleAttrPermissionInfo> queryRoleAttrPermission(String roleId) {
		List<RoleAttrPermissionInfo> result = new ArrayList<>();
		List<String> targets = roleInfoMapper.queryRoleAttrTarget();
		targets.forEach(target -> result
				.add(new RoleAttrPermissionInfo().setTarget(target).setAttrInfos(roleInfoMapper.queryAttrInfo(target))
						.setRoleAttrPermissionKeys(roleInfoMapper.queryRoleAttrPermissionKey(target, roleId))));
		return result;
	}

	@Override
	public List<RoleOperationPermissionInfo> queryRoleOperationPermission(String roleId) {
		List<RoleOperationPermissionInfo> result = new ArrayList<>();
		List<String> targets = roleInfoMapper.queryRoleOperationTarget();
		targets.forEach(target -> result
				.add(new RoleOperationPermissionInfo().setTarget(target).setOperationInfos(roleInfoMapper.queryOperationInfo(target))
						.setRoleOperationPermissionKeys(roleInfoMapper.queryRoleOperationPermissionKey(target, roleId))));
		return result;
	}
}
