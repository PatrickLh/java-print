package com.codeio.print.model;

public class OrderOfferDto {
	// 优惠的数量
	private Integer amount;
	// 优惠券类型
	private Integer type;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
