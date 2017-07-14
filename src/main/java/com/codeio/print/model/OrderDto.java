package com.codeio.print.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {
	private Integer id;

    private String orderNo;

    private Integer signalType;

    private Integer memberId;

    private Integer memberAddressId;

    private Date signalStarttime;

    private String signalEmployee;

    private Date productionStarttime;

    private String productionEmployee;

    private Date deliveryStarttime;

    private Date deliveryEndtime;

    private String deliveryEmployee;

    private BigDecimal offer;

    private Integer payType;

    private String payTime;

    private BigDecimal userPay;

	private BigDecimal totalPrice;

    private String remark;

    private Integer status;

    private Date completeTime;

    private String cancelReason;

    private String prepayId;

    private String wxPayNo;
    			   
    private String wantedDeliveryTime;
    
    private Integer printStatus;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getSignalType() {
		return signalType;
	}

	public void setSignalType(Integer signalType) {
		this.signalType = signalType;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMemberAddressId() {
		return memberAddressId;
	}

	public void setMemberAddressId(Integer memberAddressId) {
		this.memberAddressId = memberAddressId;
	}

	public Date getSignalStarttime() {
		return signalStarttime;
	}

	public void setSignalStarttime(Date signalStarttime) {
		this.signalStarttime = signalStarttime;
	}

	public String getSignalEmployee() {
		return signalEmployee;
	}

	public void setSignalEmployee(String signalEmployee) {
		this.signalEmployee = signalEmployee;
	}

	public Date getProductionStarttime() {
		return productionStarttime;
	}

	public void setProductionStarttime(Date productionStarttime) {
		this.productionStarttime = productionStarttime;
	}

	public String getProductionEmployee() {
		return productionEmployee;
	}

	public void setProductionEmployee(String productionEmployee) {
		this.productionEmployee = productionEmployee;
	}

	public Date getDeliveryStarttime() {
		return deliveryStarttime;
	}

	public void setDeliveryStarttime(Date deliveryStarttime) {
		this.deliveryStarttime = deliveryStarttime;
	}

	public Date getDeliveryEndtime() {
		return deliveryEndtime;
	}

	public void setDeliveryEndtime(Date deliveryEndtime) {
		this.deliveryEndtime = deliveryEndtime;
	}

	public String getDeliveryEmployee() {
		return deliveryEmployee;
	}

	public void setDeliveryEmployee(String deliveryEmployee) {
		this.deliveryEmployee = deliveryEmployee;
	}

	public BigDecimal getOffer() {
		return offer;
	}

	public void setOffer(BigDecimal offer) {
		this.offer = offer;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getWxPayNo() {
		return wxPayNo;
	}

	public void setWxPayNo(String wxPayNo) {
		this.wxPayNo = wxPayNo;
	}

	public String getWantedDeliveryTime() {
		return wantedDeliveryTime;
	}

	public void setWantedDeliveryTime(String wantedDeliveryTime) {
		this.wantedDeliveryTime = wantedDeliveryTime;
	}

	public BigDecimal getUserPay() {
		return userPay;
	}

	public void setUserPay(BigDecimal userPay) {
		this.userPay = userPay;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(Integer printStatus) {
		this.printStatus = printStatus;
	}
}