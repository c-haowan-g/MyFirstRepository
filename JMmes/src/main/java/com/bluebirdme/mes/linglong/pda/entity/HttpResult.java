package com.bluebirdme.mes.linglong.pda.entity;

public class HttpResult {
	private String code = "1000";
	private String msg = "强列建议将所有成员变量进行初始化，真不知从数据库里取出什么奇葩数据。";
	private String results = "";

	@Override
	public String toString() {
		return "HttpResult{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", results='" + results + '\'' + '}';
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

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}
}
