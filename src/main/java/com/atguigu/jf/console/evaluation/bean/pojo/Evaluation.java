package com.atguigu.jf.console.evaluation.bean.pojo;

import java.util.Date;

public class Evaluation {

	// 评论Id
	private Integer evaluationId;
	// 评论账号
	private String evaluateAcount;
	// 商品名称
	private String commodityName;
	// 商品图片
	private String commodityPic;
	// 评论分值
	private Double evaluationGrade;
	// 评论内容
	private String evaluationContent;
	// 评论图片
	private String evaluationPic;
	// 评论店铺
	private String evaluationStore;
	// 评论时间
	private Date evaluationTime;
	
	//商家名称
	private String  mcthName; 
	
	//评论状态
	private Integer evaluationStatus;
	
	

	public Integer getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(Integer evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	public String getMcthName() {
		return mcthName;
	}

	public void setMcthName(String mcthName) {
		this.mcthName = mcthName;
	}

	public Evaluation() {
	}

	public Evaluation(Integer evaluationId, String evaluateAcount,
			String commodityName, String commodityPic, Double evaluationGrade,
			String evaluationContent, String evaluationPic,
			String evaluationStore, Date evaluationTime) {
		super();
		this.evaluationId = evaluationId;
		this.evaluateAcount = evaluateAcount;
		this.commodityName = commodityName;
		this.commodityPic = commodityPic;
		this.evaluationGrade = evaluationGrade;
		this.evaluationContent = evaluationContent;
		this.evaluationPic = evaluationPic;
		this.evaluationStore = evaluationStore;
		this.evaluationTime = evaluationTime;
	}

	public Integer getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}

	public String getEvaluateAcount() {
		return evaluateAcount;
	}

	public void setEvaluateAcount(String evaluateAcount) {
		this.evaluateAcount = evaluateAcount;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPic() {
		return commodityPic;
	}

	public void setCommodityPic(String commodityPic) {
		this.commodityPic = commodityPic;
	}

	public Double getEvaluationGrade() {
		return evaluationGrade;
	}

	public void setEvaluationGrade(Double evaluationGrade) {
		this.evaluationGrade = evaluationGrade;
	}

	public String getEvaluationContent() {
		return evaluationContent;
	}

	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}

	public String getEvaluationPic() {
		return evaluationPic;
	}

	public void setEvaluationPic(String evaluationPic) {
		this.evaluationPic = evaluationPic;
	}

	public String getEvaluationStore() {
		return evaluationStore;
	}

	public void setEvaluationStore(String evaluationStore) {
		this.evaluationStore = evaluationStore;
	}

	public Date getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(Date evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	@Override
	public String toString() {
		return "Evaluation [evaluationId=" + evaluationId + ", evaluateAcount="
				+ evaluateAcount + ", commodityName=" + commodityName
				+ ", commodityPic=" + commodityPic + ", evaluationGrade="
				+ evaluationGrade + ", evaluationContent=" + evaluationContent
				+ ", evaluationPic=" + evaluationPic + ", evaluationStore="
				+ evaluationStore + ", evaluationTime=" + evaluationTime
				+ ", mcthName=" + mcthName + ", evaluationStatus="
				+ evaluationStatus + "]";
	}


}
