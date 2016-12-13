package com.atguigu.jf.console.role.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.jf.console.common.bean.bo.ResultBean;
import com.atguigu.jf.console.role.bean.bo.SysRoleFunc;
import com.atguigu.jf.console.role.bean.pojo.Role;
import com.atguigu.jf.console.role.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("role")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * 
	 * @方法名: saveRoleFunc
	 * @功能描述: 保存菜单关系
	 * @param funcList
	 * @param roleId
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月11日
	 */
	@RequestMapping(value = "saveRoleFunc", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean saveRoleFunc(
			@RequestParam(value = "funcList") String funcList,
			@RequestParam(value = "roleId") String roleId) throws Exception {
		
		 ResultBean rs = new ResultBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		// 1.2 执行删除
		roleService.deleteSysRoleFuncByRoleId(map);
		// 2、再新增 ①根据 “，” 进行分割
		String funcarray [] = funcList.split(",");
	
		List<SysRoleFunc> list = new ArrayList<SysRoleFunc>();
		for (int i = 0; i < funcarray.length; i++) {
			SysRoleFunc srf = new SysRoleFunc();
				//②封装对象
			 if(funcarray[i] != null && funcarray[i].length() > 0){
				 srf.setFuncId(Long.parseLong(funcarray[i]));
				 srf.setCreator(1L);
				 srf.setRoleId(Long.parseLong(roleId));
				 list.add(srf);
			 }
		}
		//当list有值时，进行保存，若没有，直接删除数据
		if(list.size()!=0){
			 //2.4 将list当作参数传入
		     roleService.inertBatchSysRoleFunc(list);
		}
	     //3 构造返回结果
	     rs.setResult(ResultBean.RESULT_SUCCESS);
	     rs.setMsg("保存成功");
	     return rs;
	}

	/**
	 * 
	 * @方法名: selectSysOpRoleList
	 * @功能描述: 显示角色列表
	 * @param page
	 * @param limit
	 * @param sysOp
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月10日
	 */
	@ResponseBody
	@RequestMapping("selectSysOpRoleList")
	public PageInfo<Role> selectSysOpRoleList(Integer page, Integer limit,
			String roleName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (roleName != null) {
			map.put("roleName", roleName);
		}
		// 获取第一页，10条内容，默认总数count
		PageHelper.startPage(page, limit);
		// 通过方法获得list对象
		List<Role> list = roleService.selectSysOpRoleListPageHelper(map);
		// 使用PageInfo包装list对象
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
