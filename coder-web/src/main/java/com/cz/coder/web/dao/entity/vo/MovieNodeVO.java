package com.fq.dao.entity.vo;

/**
 * 
 * @ClassName MovieNodeVO  
 * @Description 节点信息  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-2-2
 */
public class MovieNodeVO {
	
	private String mId;
	private String mpId;
	private String nodeId;
	private String nodeName;
    private String mpName;
    private String writeDate;
    private String isLast;
    
    
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getMpId() {
		return mpId;
	}
	public void setMpId(String mpId) {
		this.mpId = mpId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getMpName() {
		return mpName;
	}
	public void setMpName(String mpName) {
		this.mpName = mpName;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIsLast() {
		return isLast;
	}
	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
}