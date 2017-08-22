package com.cz.coder.common.entity;

import java.math.BigDecimal;

import com.cz.coder.common.constant.CommonConstant;

/**
 * 系统参数
 * @author zhen.cheng
 *
 */
public class SpSysInfo implements java.io.Serializable {

	private static final long serialVersionUID = 7512416185248380053L;
	
	private String sysParaId;
	private String key1;
	private String key2;
	private String key3;
	private String keyName;
	private Integer keyInt;
	private String keyDate;
	private BigDecimal keyFloat;
	private String keyValue1;
	private String keyValue2;
	private String keyValue3;

	public SpSysInfo() {
	}

	public SpSysInfo(String sysParaId, String key1, String key2, String key3,
			String keyName) {
		this.sysParaId = sysParaId;
		this.key1 = key1;
		this.key2 = key2;
		this.key3 = key3;
		this.keyName = keyName;
	}

	public SpSysInfo(String sysParaId, String key1, String key2, String key3,
			String keyName, Integer keyInt, String keyDate,
			BigDecimal keyFloat, String keyValue1, String keyValue2,
			String keyValue3) {
		this.sysParaId = sysParaId;
		this.key1 = key1;
		this.key2 = key2;
		this.key3 = key3;
		this.keyName = keyName;
		this.keyInt = keyInt;
		this.keyDate = keyDate;
		this.keyFloat = keyFloat;
		this.keyValue1 = keyValue1;
		this.keyValue2 = keyValue2;
		this.keyValue3 = keyValue3;
	}

	public String getSysParaId() {
		return this.sysParaId;
	}

	public void setSysParaId(String sysParaId) {
		this.sysParaId = sysParaId;
	}

	public String getKey1() {
		return this.key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return this.key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return this.key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}


	public Integer getKeyInt() {
		return keyInt;
	}

	public void setKeyInt(Integer keyInt) {
		this.keyInt = keyInt;
	}

	public String getKeyDate() {
		return this.keyDate;
	}

	public void setKeyDate(String keyDate) {
		this.keyDate = keyDate;
	}

	public BigDecimal getKeyFloat() {
		return this.keyFloat;
	}

	public void setKeyFloat(BigDecimal keyFloat) {
		this.keyFloat = keyFloat;
	}

	public String getKeyValue1() {
		return this.keyValue1;
	}

	public void setKeyValue1(String keyValue1) {
		this.keyValue1 = keyValue1;
	}

	public String getKeyValue2() {
		return this.keyValue2;
	}

	public void setKeyValue2(String keyValue2) {
		this.keyValue2 = keyValue2;
	}

	public String getKeyValue3() {
		return this.keyValue3;
	}

	public void setKeyValue3(String keyValue3) {
		this.keyValue3 = keyValue3;
	}
	
	@Override
	public int hashCode(){
		StringBuilder key = new StringBuilder().append(key1).append(CommonConstant.SYMBOL_UNDERLINE).append(key2).append(CommonConstant.SYMBOL_UNDERLINE).append(key3) ;
		return key.toString().hashCode() ;
		
	}
	
	@Override
	public boolean equals(Object c){
		
		if( c == null ){
			return false ;
		}
		if( !SpSysInfo.class.isInstance(c) ){
			return false ;
		}
		SpSysInfo comparer = (SpSysInfo)c;
		if( !( comparer.getKey1().equals(this.getKey1()) &&  
			   comparer.getKey2().equals(this.getKey2()) && 
			   comparer.getKey3().equals(this.getKey3())) ){
			return false ;
		}else{
			return true ;
		}
		
	}

	@Override
	public String toString() {
		return "SpSysInfo [sysParaId=" + sysParaId + ", key1=" + key1
				+ ", key2=" + key2 + ", key3=" + key3 + ", keyName=" + keyName
				+ ", keyInt=" + keyInt + ", keyDate=" + keyDate + ", keyFloat="
				+ keyFloat + ", keyValue1=" + keyValue1 + ", keyValue2="
				+ keyValue2 + ", keyValue3=" + keyValue3 + "]";
	}
	
	

}
