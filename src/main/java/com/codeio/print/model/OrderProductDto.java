package com.codeio.print.model;

import java.math.BigDecimal;
import java.util.List;

public class OrderProductDto {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private String productChname;

    private String productEnname;

    private Integer productCup;

    private Integer amount;

    private BigDecimal price;

    private String remark;

	private String offerId;

	private BigDecimal offerPrice;
	
	private String description;

	private List<AttachmentDto> attachmentDtos;

	// 用于处理在拆分产品时，同类产品的标志
	private Integer tempGroupSequence;
	// 用于处理临时绑定的优惠券
	private MemberOffer tempMemberOffer;
	// 用于处理临时拆分产品时是否使用优惠的标志
	private boolean tempChoosed;
	// 用于处理临时拆分产品的标准杯价格
	private BigDecimal tempStrandardPrice;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductChname() {
		return productChname;
	}

	public void setProductChname(String productChname) {
		this.productChname = productChname;
	}

	public String getProductEnname() {
		return productEnname;
	}

	public void setProductEnname(String productEnname) {
		this.productEnname = productEnname;
	}

	public Integer getProductCup() {
		return productCup;
	}

	public void setProductCup(Integer productCup) {
		this.productCup = productCup;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<AttachmentDto> getAttachmentDtos() {
		return attachmentDtos;
	}

	public void setAttachmentDtos(List<AttachmentDto> attachmentDtos) {
		this.attachmentDtos = attachmentDtos;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTempGroupSequence() {
		return tempGroupSequence;
	}

	public void setTempGroupSequence(Integer tempGroupSequence) {
		this.tempGroupSequence = tempGroupSequence;
	}
	
	public MemberOffer getTempMemberOffer() {
		return tempMemberOffer;
	}

	public void setTempMemberOffer(MemberOffer tempMemberOffer) {
		this.tempMemberOffer = tempMemberOffer;
	}

	public boolean getTempChoosed() {
		return tempChoosed;
	}

	public void setTempChoosed(boolean tempChoosed) {
		this.tempChoosed = tempChoosed;
	}

	public BigDecimal getTempStrandardPrice() {
		return tempStrandardPrice;
	}

	public void setTempStrandardPrice(BigDecimal tempStrandardPrice) {
		this.tempStrandardPrice = tempStrandardPrice;
	}
}