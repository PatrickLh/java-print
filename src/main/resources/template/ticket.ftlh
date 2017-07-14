<!DOCTYPE html>
<html>
	<head>
		<style>
		body {
			font-family: 'Microsoft YaHei';
			margin:0;
			padding:0;
		}
		.order-print {
		    width: 8cm;
		    /*margin: auto;*/
		    border: 1px solid #000;
		}
		.order-print .header{
		    border-bottom: 1px solid #000;
		    padding: 0.25cm;
		    height: 5.3cm;
		}
		.order-print .header h2{
		    text-align: center;
		}
		.order-print .product-list{
		    border-bottom: 1px solid #000;
		}
		.order-print .product-list .product{
		    display: flex;
		    padding: 0.25cm;
		    height: 3cm;
		}
		.order-print .product-list .product .left{
		    width:72%;
		    border: 1px solid #000;
		    border-radius: 3px;
		    padding: 5px;
			float: left;
			height: 6rem;
		}
		.order-print .product-list .product .left .cuptype{
		    border-bottom: 1px solid #000;
		}
		.order-print .product-list .product .right{
		    width:20%;
		    padding: 5px;
			float: left;
		}
		.order-print .footer{
		    display: flex;
		    padding: 0.25cm;
		}
		.order-print .footer .qrcode{
		    text-align:left;
		}
		.order-print .footer .price{
		    width: 50%;
		    text-align: right;
		    float:right;
		}
		</style>
	</head>
	<body>
		<div class="order-print" id="orderPrint" style="width: 8cm; border: 1px solid #000;">
		    <div class="header" style="border-bottom: 1px solid #000; padding: 0.25cm; height:5.3cm">
		      <h2 style="text-align: center;">COFFEE PENNY</h2>
		      <div>
		      	<span>订单号：</span>
		      	<#if order.orderDto?? && order.orderDto.orderNo??>
		      		<span>${order.orderDto.orderNo}</span>
		      	</#if>
		      </div>
		      <div>
		      	<span>联系人：</span>
	      		<#if order.memberAddressDto?? && order.memberAddressDto.consigneeName??>
	      			<span>${order.memberAddressDto.consigneeName}</span>
	      		</#if>
		      </div>
		      <div>
		      	<span>电话：</span>
		      	<#if order.memberAddressDto?? && order.memberAddressDto.consigneePhone??>
		      		<span>${order.memberAddressDto.consigneePhone}</span>
		      	</#if>
	      	  </div>
		      <div>
		      	<span>目的地：</span>
		      	<#if order.memberAddressDto?? && order.memberAddressDto.address??>
		      		<span>${order.memberAddressDto.address}</span>
		      	</#if>
		      </div>
		    </div>
		    <#list order.orderProductDtos as orderProduct>
			  <div class="product-list" style="border-bottom: 1px solid #000;">
			      <div class="product" style="display: flex; padding: 0.25cm; height: 3cm;">
			        <div class="left" style="width:72%; border: 1px solid #000;border-radius: 3px; padding: 5px;">
			          <div class="name">${orderProduct.productChname}(${orderProduct.productEnname})</div>
			          <div class="cuptype" style="border-bottom: 1px solid #000;">
			          	<#if orderProduct.productCup??>${orderProduct.productCup}</#if>
			          </div>
			          <div class="attachements">
			          	<#list orderProduct.attachmentDtos as attachment>
			            	<span>
			            		<#if attachment.name?? && attachment.price??>
			            			${attachment.name} * ${attachment.price}
			            		</#if>
			            	</span>
			            </#list>
			           </div>
			        </div>
			        <div class="right" style="width:20%;padding: 5px;">
			          <div class="amount">X <#if orderProduct.amount??>${orderProduct.amount}</#if></div>
			          <div class="price">￥ <#if orderProduct.price??>${orderProduct.price}</#if></div>
			        </div>
			      </div>
			    </div>
			</#list>
		    <div class="footer" style="display: flex; padding: 0.25cm;">
		      <div class="qrcode" style="text-align:left;float:left">
		        <#if qrcode??><img src="${qrcode}"></img></#if>
		      </div>
		      <div class="price" style="width: 50%; text-align: right;float:right">
		        <div>
		        	<span>总金额：</span>
		        	<#if order.orderDto?? && order.orderDto.totalPrice??>
		        		<span>￥ ${order.orderDto.totalPrice}</span>
		        	</#if>
	        	</div>
		        <div>
		        	<span>优惠：</span>
		        	<#if order.orderDto?? && order.orderDto.offer??>
		        		<span>￥ ${order.orderDto.offer}</span>
		        	</#if>
		        </div>
		        <div>
		        	<span>支付：</span>
		        	<#if order.orderDto?? && order.orderDto.userPay??>
		        		<span>￥ ${order.orderDto.userPay}</span>
		        	</#if>
		        </div>
		      </div>
		      <div style="clear:both"></div>
		    </div>
		  </div>
	  </body>
  </html>