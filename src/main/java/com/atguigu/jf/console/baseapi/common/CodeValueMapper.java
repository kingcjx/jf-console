package com.atguigu.jf.console.baseapi.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.jf.console.common.bean.pojo.CodeValue;

public interface CodeValueMapper {
    int deleteByPrimaryKey(@Param("codeType") Integer codeType, @Param("codeValue") String codeValue);

    int insert(CodeValue record);

    CodeValue selectByPrimaryKey(@Param("codeType") Integer codeType, @Param("codeValue") String codeValue);

    List<CodeValue> selectAll();

    int updateByPrimaryKey(CodeValue record);
    
   List<CodeValue> selectCodeValueByType(Map<String,Object> map) throws Exception;
}