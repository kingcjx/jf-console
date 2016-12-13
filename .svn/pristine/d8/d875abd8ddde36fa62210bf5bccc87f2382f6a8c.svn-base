package com.atguigu.jf.console.role.service;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.role.bean.bo.SysRoleFunc;
import com.atguigu.jf.console.role.bean.pojo.Role;

public interface RoleService {
	/**
	 * 
	 * @方法名: deleteSysRoleFuncByRoleId  
	 * @功能描述: 根据roleID删除sys_role_func数据
	 * @param map
	 * @return
	 * @throws Exception 
	 * @作者  cjx
	 * @日期 2016年11月11日
	 */
	int deleteSysRoleFuncByRoleId(Map<String, Object> map) throws Exception;

	 /**
     * 
     * @方法名: selectSysOpRoleListPageHelper  
     * @功能描述: 分页获得角色对象
     * @param map
     * @return
     * @作者  cjx
     * @日期 2016年11月10日
     */
	List<Role> selectSysOpRoleListPageHelper(Map<String,Object> map) throws Exception;
	/**
	 * 
	 * @方法名: inertBatchSysRoleFunc  
	 * @功能描述: 批量保存菜单配置
	 * @param list
	 * @作者  cjx
	 * @日期 2016年11月11日
	 */
	void inertBatchSysRoleFunc(List<SysRoleFunc> list);

}
