package com.codeio.print.model;

public class Response<T> {
	
	public static final String SUCCESS_CODE = "10000";
	
	public static final String DEFAULT_MSG = "SUCCESS";
	
	// 响应码
	private String code;
	// 响应信息
	private String msg;
	// 响应数据
	private T data;

	public static Response create(){
		Response response = new Response();
		response.setCode(SUCCESS_CODE);
		response.setMsg(DEFAULT_MSG);
		return response;
	}
	
	public static Response create(String code, String msg){
		Response response = new Response();
		response.setCode(code);
		response.setMsg(msg);
		return response;
	}

	public static Response create(Object obj){
		Response response = new Response();
		response.setCode(SUCCESS_CODE);
		response.setMsg(DEFAULT_MSG);
		response.setData(obj);
		return response;
	}

    public static Response error(Exception e){
    	Response response = new Response();
    	response.setCode(e.getMessage()) ;
    	response.setMsg(ResponseCode.valueOf(e.getMessage()).getMsg());
        return response;
    }
	
	public static Response error(ResponseCode responseCode){
		Response response = new Response();
		response.setCode(responseCode.getCode());
		response.setMsg(responseCode.getMsg());
		return response;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
