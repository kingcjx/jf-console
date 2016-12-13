package com.atguigu.jf.console.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.baseapi.user.SysFuncChkMapper;
import com.atguigu.jf.console.baseapi.user.SysOpMapper;
import com.atguigu.jf.console.user.bean.bo.SysFuncChkBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;
import com.atguigu.jf.console.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysOpMapper sysOpMapper;
	
	
	@Autowired
	private SysFuncChkMapper sysFuncChkMapper;

	public int seletctTotalCount(SysOp sysOp) throws Exception {
		int totalCount = sysOpMapper.seletctTotalCount(sysOp);
		return totalCount;
	}

	public List<SysOp> selectSysOpList(int start, int limit, SysOp sysOp)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		if (sysOp.getOpName() != null) {
			map.put("opName", sysOp.getOpName());
		}
		if (sysOp.getOpKind() != null) {
			map.put("opKind", sysOp.getOpKind());
		}
		map.put("start", start);
		map.put("limit", limit);
		map.put("sysOp", sysOp);
		List<SysOp> list = sysOpMapper.selectSysOpList(map);
		return list;
	}

	@Override
	public int insertUser(SysOp sysOp) throws Exception {

		return sysOpMapper.insert(sysOp);
	}

	@Override
	public int updateByPrimaryKey(SysOp sysOp) throws Exception {
		return sysOpMapper.updateByPrimaryKey(sysOp);
	}

	@Override
	public SysOp selectByPrimaryKey(Long opId) throws Exception{
		return sysOpMapper.selectByPrimaryKey(opId);
	}

	@Override
	public int deleteUser(Long opId) throws Exception{
		
		return sysOpMapper.deleteUser(opId);
	}

	@Override
	public List<SysOp> selectSysOpListPageHelper(Map<String, Object> map)
			throws Exception {
		
		return  sysOpMapper.selectSysOpListPageHelper(map);
	}

	@Override
	public List<SysFuncChkBean> selectRoleMenuList(Map<String,Object> map) throws Exception {
		
		return sysFuncChkMapper.selectRoleMenuList(map);
	}

	@Override
	public List<SysFuncChkBean> getOpIdByRoleId(Map<String,Object> map) {
		
		return sysFuncChkMapper.getOpIdByRoleId(map);
	}


	@Override
	public SysOp getProviderByName(Map<String, Object> map) throws Exception {
		return sysFuncChkMapper.getProviderByName(map);
	}

}
