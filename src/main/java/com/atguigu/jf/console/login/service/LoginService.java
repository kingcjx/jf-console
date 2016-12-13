package com.atguigu.jf.console.login.service;

import java.util.List;

import com.atguigu.jf.console.user.bean.bo.SysFuncBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

public interface LoginService {

	/**
	 * 
	 * @方法名: getLogin
	 * @功能描述: 根据用户名和密码查询对应的数据库对象
	 * @param loginCode
	 * @param passWord
	 * @return
	 * @throws Exception 
	 * @作者 cjx
	 * @日期 2016年11月7日
	 */
	SysOp getLogin(SysOp sysOp) throws Exception;

	/**
	 * 
	 * @方法名: getMenu
	 * @功能描述: 获取菜单列表
	 * @param opId
	 * @return
	 * @作者 cjx
	 * @日期 2016年11月7日
	 */
	List<SysFuncBean> getMenu(Long opId) throws Exception;
	
}
