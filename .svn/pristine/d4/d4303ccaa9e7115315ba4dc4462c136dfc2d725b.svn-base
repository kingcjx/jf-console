package com.atguigu.jf.console.baseapi.user;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.user.bean.pojo.SysOp;


public interface SysOpMapper {
    int deleteByPrimaryKey(Long opId);

    int insert(SysOp record) throws Exception;

    SysOp selectByPrimaryKey(Long opId);

    List<SysOp> selectAll();

    int updateByPrimaryKey(SysOp record) throws Exception;
    /**
     * 
     * @方法名: selectSysOpByUnameAndPwd  
     * @功能描述: 根据用户名和密码查询对象
     * @param sysOp
     * @return
     * @throws Exception
     * @作者  cjx
     * @日期 2016年11月9日
     */
    SysOp selectSysOpByUnameAndPwd(SysOp sysOp)throws Exception;
    /**
     * 
     * @方法名: seletctTotalCount  
     * @功能描述: 查询总记录数
     * @param sysOp
     * @return
     * @throws Exception
     * @作者  cjx
     * @日期 2016年11月9日
     */
	int seletctTotalCount(SysOp sysOp)throws Exception;
	/**
	 * 
	 * @方法名: selectSysOpList  
	 * @功能描述: 传统分页查询
	 * @param map
	 * @return
	 * @throws Exception
	 * @作者  cjx
	 * @日期 2016年11月9日
	 */
	List<SysOp> selectSysOpList(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * @方法名: selectSysOpListPageHelper  
	 * @功能描述: 使用pagehelper插件进行分页
	 * @param map
	 * @return
	 * @throws Exception
	 * @作者  cjx
	 * @日期 2016年11月9日
	 */
	List<SysOp> selectSysOpListPageHelper(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * @方法名: deleteUser  
	 * @功能描述: 删除方法
	 * @param opId
	 * @return
	 * @作者  cjx
	 * @日期 2016年11月9日
	 */
	int deleteUser(Long opId);
    
}