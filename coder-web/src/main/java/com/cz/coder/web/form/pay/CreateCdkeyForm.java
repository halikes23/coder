package com.fq.form.pay;

/**
 * 
 * @ClassName CreateCdkeyForm  
 * @Description 创建新的cdkey  form  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-22
 */
public class CreateCdkeyForm {

	private Integer jPoint  ; // 面值
	private Integer amount ; // 数量
	private Integer repeatTimes ; // 兑换次数
	private String startDt ; // 有效期起始时间
	private String endDt ; // 有效期结束时间
	
	public Integer getjPoint() {
		return jPoint;
	}
	public void setjPoint(Integer jPoint) {
		this.jPoint = jPoint;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getRepeatTimes() {
		return repeatTimes;
	}
	public void setRepeatTimes(Integer repeatTimes) {
		this.repeatTimes = repeatTimes;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
}
