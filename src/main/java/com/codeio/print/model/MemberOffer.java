package com.codeio.print.model;

import java.util.Date;

public class MemberOffer {
	// 优惠券ID
	private Integer id;
	// 优惠券所属会员
	private Integer memberId;
	// 优惠券类型（1：买一送一，2：免费升杯，3。免费饮料）
	private Integer type;
	// 优惠券生成日期
	private Date createTime;
	// 优惠券使用日期
	private Date useTime;
	// 优惠券状态(0：已使用，1：未使用)
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
