package com.c.c.enums;

/**
 * 图片来源
 */
public enum HttpUnitReqEnum {
	
	GENERAL("general","general"),
	GET("get","get"),
	POST("post","POST"),
	;
	
	private String code;
	private String desc;
	
	HttpUnitReqEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
