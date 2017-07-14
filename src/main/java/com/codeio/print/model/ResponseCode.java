package com.codeio.print.model;

/**
 * 响应常量类
 */
public enum ResponseCode {
	
	// 系统异常
	SYSTEM_ERROR("SYSTEM_ERROR","系统异常！"),
	PARAM_ERROR("PARAM_ERROR","参数异常"),
	// 微信异常
	WECHAT_AUTHOR_ERROR("WECHAT_AUTHOR_ERROR","微信授权异常！"),
	WECHAT_OPENID_ERROR("WECHAT_OPENID_ERROR", "获取OPENID异常！"),
	WECHAT_PREPAY_ERROR("WECHAT_PREPAY_ERROR", "获取预支付信息异常，未找到相关订单！"),
	WECHAT_PAY_FEE_ERROR("WECHAT_PAY_FEE_ERROR", "支付异常，支付金额存在异常！"),
	WECHAT_PAY_ORDERNOTFOUND_ERROR("WECHAT_PAY_ORDERNOTFOUND_ERROR", "支付异常，未找到相关订单！"),
	WECHAT_PAY_SIGN_ERROR("WECHAT_PAY_SIGN_ERROR", "支付异常，支付签名验证失败！"),
	
	EM_LG1001("EM_LG1001","员工登录名称不能为空！"),
	EM_LG1002("EM_LG1002","员工登录密码不能为空！"),
	EM_LG1003("EM_LG1003","员工不存在！"),
	EM_LG1004("EM_LG1004","密码错误！"),
	EM_LG1005("EM_LG1005","验证码不能为空！"),
	EM_LG1006("EM_LG1006","验证码有误！"),
	EM_LG1007("EM_LG1007","该员工已离职，不能进行登录操作！"),

	EM1001("EM1001","员工名称不能为空！"),
	EM1002("EM1002","电话号码不能为空！"),
	EM1003("EM1003","旧密码不能为空！"),
	EM1004("EM1004","新密码不能为空！"),
	EM1005("EM1005","输入的旧密码有误！"),
	EM1006("EM1006","输入的两次新密码不一致！"),

	PRTYPE_DE1001("PRTYPE_DE1001","此产品类型下还有产品，不能被删除"),
	
	//----角色异常----
	RO1001("RO1001","新增角色异常"),
	RO1002("RO1002","修改角色异常"),
	RO1003("RO1003","删除角色异常"),
	RO1004("RO1004","查询角色异常"),
	RO1005("RO1005","存在当前使用该角色的雇员，不能删除该角色"),
	//----产品附加物异常----
	AT1001("AT1001","新增产品附加物异常"),
	AT1002("AT1002","修改产品附加物异常"),
	AT1003("AT1003","删除产品附加物异常"),
	AT1004("AT1004","查询产品附加物异常"),
	
	//----订单异常----
	OR1001("OR1001","新增订单异常"),
	OR1002("OR1002","修改订单异常"),
	OR1003("OR1003","删除订单异常"),
	OR1004("OR1004","查询订单异常"),
	OR1005("OR1005","优惠券数量异常，请刷新后重新选择"),
	OR1006("OR1006","选择产品数量为空，请重新选择"),
	OR1007("OR1007","订单状态异常，订单退款失败"),
	OR1008("OR1008","退款异常，不能进行退款操作"),
	OR1009("OR1009","获取雇员异常，不能进行状态更新"),
	OR1010("OR1010","获取会员信息失败"),
	OR1011("OR1011","订单状态更新异常"),
	//----会员卡异常----
	MC1001("MC1001","新增会员卡异常"),
	MC1002("MC1002","绑定会员卡异常"),
	MC1003("MC1003","设置会员卡异常"),
	MC1004("MC1004","查询会员卡异常"),
	MC1005("MC1005","删除会员卡异常"),
	MC1006("MC1006","会员卡信息不存在"),
	MC1007("MC1007","会员卡已激活，不能进行删除"),
	//----员工考勤异常----
	DT1001("DT1001","签到用户不存在"),
	DT1002("DT1002","当前经理不存在或没有权限"),
	DT1003("DT1003","考勤异常"),

	//----用户异常----
	ME1001("ME1001", "此用户不存在"),
	MECD1002("MECD1002", "此用户没有会员卡"),
	MEOR1003("MEOR1003", "此用户没有优惠劵"),
	MECD1004("MECD1004", "没有查询到此会员卡"),
	MECD1005("MECD1005", "没有查询到此会员卡相关用户");
	protected String code;
	protected String msg;

	ResponseCode(String code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}