package com.atguigu.jf.console.role.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.baseapi.role.RoleMapper;
import com.atguigu.jf.console.role.bean.bo.SysRoleFunc;
import com.atguigu.jf.console.role.bean.pojo.Role;
import com.atguigu.jf.console.role.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int deleteSysRoleFuncByRoleId(Map<String, Object> map) throws Exception {
		
		return roleMapper.deleteSysRoleFuncByRoleId(map);
	}

	@Override
	public List<Role> selectSysOpRoleListPageHelper(Map<String,Object> map) throws Exception {
		
		return roleMapper.selectSysOpRoleListPageHelper(map);
	}

	@Override
	public void inertBatchSysRoleFunc(List<SysRoleFunc> list) {
		roleMapper.inertBatchSysRoleFunc(list);
	}
	
}
