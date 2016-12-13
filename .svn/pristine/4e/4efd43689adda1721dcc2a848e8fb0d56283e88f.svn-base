package com.atguigu.jf.console.evaluation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.baseapi.evaluation.EvaluationMapper;
import com.atguigu.jf.console.evaluation.bean.pojo.Evaluation;
import com.atguigu.jf.console.evaluation.service.EvaluationService;

@Service
public class EvaluationServiceImpl implements EvaluationService{

	@Autowired
	private EvaluationMapper evaluationMapper;
	
	@Override
	public List<Evaluation> getEvaluationList(Map map) {
		return evaluationMapper.getEvaluationList(map);
	}

	@Override
	public Evaluation getInfoEvaluation(Evaluation evaluation) {
		Evaluation evaluation1=evaluationMapper.getInfoEvaluation(evaluation);
		return evaluation1;
	}

	@Override
	public void updateEvaluateStatus(Evaluation evaluation) {
		evaluationMapper.updateEvaluateStatus(evaluation);
		
	}


}
