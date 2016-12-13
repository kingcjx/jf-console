package com.atguigu.jf.console.evaluation.service;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.evaluation.bean.pojo.Evaluation;

public interface EvaluationService {
	List<Evaluation> getEvaluationList(Map map);

	Evaluation getInfoEvaluation(Evaluation evaluation);

	void updateEvaluateStatus(Evaluation evaluation);

}
