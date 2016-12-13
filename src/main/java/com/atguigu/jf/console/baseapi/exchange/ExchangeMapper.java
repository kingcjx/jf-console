package com.atguigu.jf.console.baseapi.exchange;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.exchange.bean.bo.ExchangeInfo;

public interface ExchangeMapper {
	
	public List<ExchangeInfo> selectPcExchangeInfoReport(Map<String, Object> map);
	
	
}