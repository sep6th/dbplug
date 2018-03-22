package com.github.dbplug;

/** 
  * @ClassName  result
  * @Description  TODO(这里用一句话描述这个类的作用) 
  * @Author  liuzy
  * @Date  2018年3月21日 下午3:05:22  
  */

public class Result {
	
	/**
	 * 状态码   失败：201；成功：200
	 */
	private Integer code;
	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回sql
	 */
	private String sql;
	/**
	 * 返回数据
	 */
	private Object data;
	
	
	public Result() {
		super();
	}
	
	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public Result(Integer code, String msg, String sql, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.sql = sql;
		this.data = data;
	}

	public static Result build(Integer code, String msg) {
		return new Result(code, msg);
	}

	public static Result build(Integer code, String msg, Object data) {
		return new Result(code, msg, data);
	}
	
	public static Result build(Integer code, String msg, String sql, Object data) {
		return new Result(code, msg, sql, data);
	}
	

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
