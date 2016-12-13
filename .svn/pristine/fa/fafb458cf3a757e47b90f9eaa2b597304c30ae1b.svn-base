package com.atguigu.jf.console.user.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.atguigu.jf.console.common.bean.bo.ResultBean;
import com.atguigu.jf.console.user.bean.bo.SysFuncChkBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;
import com.atguigu.jf.console.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @方法名: getMenuChkByOpId
	 * @功能描述: 获得sysfuncBean对象
	 * @param roleId
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月10日
	 */
	@RequestMapping("getMenuChkByOpId")
	@ResponseBody
	public List<SysFuncChkBean> getMenuChkByOpId(
			@RequestParam("roleId") Long roleId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		List<SysFuncChkBean> opIdList = userService.getOpIdByRoleId(map);
		// 同一个roleId可能对应多个opId，但这些opId对应sysOp对象的权限是相同的
		if (opIdList.size() != 0) {
			SysFuncChkBean firstBean = opIdList.get(0);
			Long opId = firstBean.getOpId();
			map.put("opId", opId);
		}
		List<SysFuncChkBean> menuList = userService.selectRoleMenuList(map);
		return menuList;
	}

	/**
	 * 
	 * @方法名: uploadFile
	 * @功能描述: 文件上传
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月10日
	 */
	@RequestMapping("uploadFile")
	public String uploadFile(MultipartFile uploadFile) throws Exception {
		ResultBean result = new ResultBean();
		// 1、指定一个文件夹用来存放上传的文件
		String path = "E:\\testUpLoad";
		// 2、进行判断如果不存在该文件夹，就创建
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		// 3、新建一个文件对象
		File file = new File(path, uploadFile.getOriginalFilename());
		// 4、通过MultipartFile的transferTo方法传输文件
		try {
			uploadFile.transferTo(file);
		} catch (Exception e) {
			result.setResult(ResultBean.RESULT_FAILED);
			result.setMsg("上传失败");
		}
		result.setResult(ResultBean.RESULT_SUCCESS);
		result.setMsg("上传成功");
		String jsonString = JSON.toJSONString(result);
		return jsonString;
	}

	/**
	 * 
	 * @方法名: deleteUser
	 * @功能描述: 删除用户
	 * @param opId
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月8日
	 */
	@RequestMapping("deleteUser")
	public String deleteUser(Long opId) throws Exception {
		userService.deleteUser(opId);
		return "redirect:/page/user/userMgnt.jsp";
	}

	/**
	 * 
	 * @方法名: addUser
	 * @功能描述: 添加用户
	 * @param sysOp
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月8日
	 */
	@RequestMapping("addUser")
	public String addUser(SysOp sysOp) throws Exception {
		userService.insertUser(sysOp);
		return "redirect:/page/user/userMgnt.jsp";
	}

	/**
	 * 
	 * @方法名: modifyUser
	 * @功能描述: 更新用户
	 * @param sysOp
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月8日
	 */
	@RequestMapping("modifyUser")
	public String modifyUser(SysOp sysOp) throws Exception {
		userService.updateByPrimaryKey(sysOp);
		return "redirect:/page/user/userMgnt.jsp";
	}

	/**
	 * 
	 * @方法名: toAddPage
	 * @功能描述: 前往添加用户页面
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月8日
	 */
	@RequestMapping("toAddPage")
	public String toAddPage(String type, Long opId, Map<String, Object> map)
			throws Exception {
		if (type != null && type.equals("modify")) {
			SysOp sysOp = userService.selectByPrimaryKey(opId);
			map.put("sysOp", sysOp);
			map.put("opId", opId);
		}
		map.put("type", type);

		return "user/add";
	}

	/**
	 * 
	 * @方法名: selectSysOpList
	 * @功能描述: 使用pageHelper进行分页
	 * @param start
	 * @param limit
	 * @param sysOp
	 * @return
	 * @throws Exception
	 * @作者 cjx
	 * @日期 2016年11月9日
	 */
	@ResponseBody
	@RequestMapping("selectSysOpList")
	public PageInfo<SysOp> selectSysOpList(Integer page, Integer limit,
			SysOp sysOp) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (sysOp.getOpName() != null) {
			map.put("opName", sysOp.getOpName());
		}
		if (sysOp.getOpKind() != null) {
			map.put("opKind", sysOp.getOpKind());
		}
		// 获取第一页，10条内容，默认总数count
		PageHelper.startPage(page, limit);
		// 通过方法获得list对象
		List<SysOp> list = userService.selectSysOpListPageHelper(map);
		// 使用PageInfo包装list对象
		PageInfo<SysOp> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * @方法名: querySysOpList
	 * @功能描述: 显示后台分页
	 * @return
	 * @作者 cjx
	 * @日期 2016年11月7日
	 */
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("selectSysOpList") public PageModel<SysOp>
	 * selectSysOpList(
	 * 
	 * @RequestParam(value = "start") int start,
	 * 
	 * @RequestParam(value = "limit") int limit, SysOp sysOp) throws Exception {
	 * 
	 * int totalCount = userService.seletctTotalCount(sysOp); List<SysOp> list =
	 * userService.selectSysOpList(start, limit, sysOp); PageModel<SysOp> page =
	 * new PageModel<SysOp>(); page.setList(list); page.setPageNo(start);
	 * page.setPageSize(limit); page.setTotalCount(totalCount); return page; }
	 */

}
