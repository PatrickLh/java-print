package com.codeio.print.model;

import java.util.List;

public class OrderAllDto {

    private OrderDto orderDto;

    private List<OrderProductDto> orderProductDtos;
    
    private OrderAddressDto orderAddressDto;

    private String userOpenId;
    
    private String userIp;
    
    private String isPlatformPay;

	private List<Integer> offerIds;

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}
	
	public List<OrderProductDto> getOrderProductDtos() {
		return orderProductDtos;
	}

	public void setOrderProductDtos(List<OrderProductDto> orderProductDtos) {
		this.orderProductDtos = orderProductDtos;
	}

	public OrderAddressDto getOrderAddressDto() {
		return orderAddressDto;
	}

	public void setOrderAddressDto(OrderAddressDto orderAddressDto) {
		this.orderAddressDto = orderAddressDto;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getIsPlatformPay() {
		return isPlatformPay;
	}

	public void setIsPlatformPay(String isPlatformPay) {
		this.isPlatformPay = isPlatformPay;
	}

	public List<Integer> getOfferIds() {
		return offerIds;
	}

	public void setOfferIds(List<Integer> offerIds) {
		this.offerIds = offerIds;
	}
}
