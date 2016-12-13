package com.atguigu.jf.console.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.jf.console.item.bean.pojo.Item;
import com.atguigu.jf.console.item.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	/**
	 * 
	 * @方法名: getAllIcItem  
	 * @功能描述: 
	 * @return
	 * @作者  cjx
	 * @日期 2016年11月12日
	 */
	public List<Item> getAllIcItem(){
		return null;
	}
	
	

}
