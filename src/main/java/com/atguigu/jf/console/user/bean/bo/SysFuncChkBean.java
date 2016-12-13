package com.atguigu.jf.console.user.bean.bo;

public class SysFuncChkBean {

	private Long funcId;
	private Short funcLevel;
	private String funcCode;
	private String funcName;
	private Integer funcOrder;
	private String funcUrl;
	private String funcImg;
	private boolean checked;
	private Long opId;
	private Long supFuncId;
	public SysFuncChkBean() {
	}
	public SysFuncChkBean(Long funcId, Short funcLevel, String funcCode,
			String funcName, Integer funcOrder, String funcUrl, String funcImg,
			boolean checked, Long opId, Long supFuncId) {
		super();
		this.funcId = funcId;
		this.funcLevel = funcLevel;
		this.funcCode = funcCode;
		this.funcName = funcName;
		this.funcOrder = funcOrder;
		this.funcUrl = funcUrl;
		this.funcImg = funcImg;
		this.checked = checked;
		this.opId = opId;
		this.supFuncId = supFuncId;
	}
	@Override
	public String toString() {
		return "SysFuncChkBean [funcId=" + funcId + ", funcLevel=" + funcLevel
				+ ", funcCode=" + funcCode + ", funcName=" + funcName
				+ ", funcOrder=" + funcOrder + ", funcUrl=" + funcUrl
				+ ", funcImg=" + funcImg + ", checked=" + checked + ", opId="
				+ opId + ", supFuncId=" + supFuncId + "]";
	}
	public Long getFuncId() {
		return funcId;
	}
	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}
	public Short getFuncLevel() {
		return funcLevel;
	}
	public void setFuncLevel(Short funcLevel) {
		this.funcLevel = funcLevel;
	}
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public Integer getFuncOrder() {
		return funcOrder;
	}
	public void setFuncOrder(Integer funcOrder) {
		this.funcOrder = funcOrder;
	}
	public String getFuncUrl() {
		return funcUrl;
	}
	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}
	public String getFuncImg() {
		return funcImg;
	}
	public void setFuncImg(String funcImg) {
		this.funcImg = funcImg;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Long getOpId() {
		return opId;
	}
	public void setOpId(Long opId) {
		this.opId = opId;
	}
	public Long getSupFuncId() {
		return supFuncId;
	}
	public void setSupFuncId(Long supFuncId) {
		this.supFuncId = supFuncId;
	}
	
	

}