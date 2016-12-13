package com.atguigu.jf.console.baseapi.user;

import java.util.List;
import java.util.Map;




import com.atguigu.jf.console.user.bean.bo.SysFuncChkBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

public interface SysFuncChkMapper {
	 /**
     * 
     * @方法名: selectRoleMenuList  
     * @功能描述: 查询opId对应的 SysFuncBean对象（opId->roleId->funcId）
     * @param opId
     * @return
     * @throws Exception
     * @作者  cjx
     * @日期 2016年11月10日
     */
    List<SysFuncChkBean> selectRoleMenuList(Map<String,Object> map) throws Exception;
    /**
     * 
     * @方法名: getOpIdByRoleId  
     * @功能描述: 通过roleId获得opId的集合
     * @param roleId
     * @return
     * @作者  cjx
     * @日期 2016年11月10日
     */
    List<SysFuncChkBean> getOpIdByRoleId(Map<String,Object> map);
    
    /**
     * 
     * @方法名: getProviderByName  
     * @功能描述: TODO(这里用一句话描述这个方法的作用)  
     * @param map
     * @return
     * @作者  cjx
     * @日期 2016年11月11日
     */
    SysOp getProviderByName(Map<String, Object> map)throws Exception;
		
   
}
