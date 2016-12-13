package com.atguigu.jf.console.evaluation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.atguigu.jf.console.evaluation.bean.pojo.Evaluation;
import com.atguigu.jf.console.evaluation.service.EvaluationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@SuppressWarnings("all")
@Controller
@RequestMapping("item")
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationService;
	
	@RequestMapping("itemEvaluationMgnt")
	@ResponseBody
	public String getEvaluationList(Integer page,Integer limit,Integer evaluationStatus,String evaluateAcount){
		PageHelper.startPage(page, limit);
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("evaluationStatus", evaluationStatus);
		if(evaluateAcount!=""){
			map.put("evaluateAcount", evaluateAcount);
		}
		List<Evaluation> evaluationList = evaluationService.getEvaluationList(map);
		
		PageInfo<Evaluation> list=new PageInfo<>(evaluationList);
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		
		return JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		
	}

	@RequestMapping("info")
	public String getInfoEvaluation(String evaluateAcount,String mcthName,String evaluationStore,Map map){
		Evaluation evaluation=new Evaluation();
		evaluation.setEvaluateAcount(evaluateAcount);
		evaluation.setMcthName(mcthName);
		evaluation.setEvaluationStore(evaluationStore);
	
		Evaluation evaluation1=evaluationService.getInfoEvaluation(evaluation);
	
		map.put("evaluation", evaluation1);
		
		return "item/evaluationInfo";
	}
	
	@RequestMapping("shield")
	public String shield(String evaluateAcount,String mcthName,String evaluationStore){
		
		Evaluation evaluation=new Evaluation();
		
		evaluation.setEvaluateAcount(evaluateAcount);
		
		evaluation.setMcthName(mcthName);
		
		evaluation.setEvaluationStore(evaluationStore);
		
		evaluationService.updateEvaluateStatus(evaluation);
		
		return "redirect:/page/index.jsp";
	}
	
}
