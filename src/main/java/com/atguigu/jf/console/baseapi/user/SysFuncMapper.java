package com.atguigu.jf.console.baseapi.user;

import java.util.List;

import com.atguigu.jf.console.user.bean.bo.SysFuncBean;

public interface SysFuncMapper {
    int deleteByPrimaryKey(Long funcId);

    int insert(SysFuncBean record);

    SysFuncBean selectByPrimaryKey(Long funcId);

    List<SysFuncBean> selectAll();

    int updateByPrimaryKey(SysFuncBean record);
    
    List<SysFuncBean> selectMenuList(Long opId);
   
    
}