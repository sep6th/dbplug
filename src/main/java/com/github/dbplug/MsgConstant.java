package com.github.dbplug;

/** 
  * @ClassName  MsgConstant
  * @Description  TODO(这里用一句话描述这个类的作用) 
  * @Author  liuzy
  * @Date  2018年3月21日 下午3:16:23  
  */

public class MsgConstant {

	/**
	 * 响应码
     * 200	成功
     */
	public static final Integer RESULT_CODE_SUCCES = 200;
	/**
	 * 响应码
     * 201	错误
     */
	public static final Integer RESULT_CODE_ERROR = 201;
	
	/**
	 * 成功
	 */
	public static final String SUCCESS = "成功！";
	/**
	 * 失败
	 */
	public static final String ERROR = "失败！";
	/**
	 * 加载驱动成功
	 */
	public static final String LOAD_DRIVER_SUCCESS = "加载驱动成功！";
	/**
	 * 加载驱动失败
	 */
	public static final String LOAD_DRIVER_ERROR = "加载驱动失败！";
	/**
	 * 初始化C3P0成功
	 */
	public static final String INIT_C3P0_SUCCESS = "初始化C3P0成功！";
	/**
	 * 初始化C3P0失败
	 */
	public static final String INIT_C3P0_ERROR = "初始化C3P0失败！";
	/**
	 * 初始化JDBC成功
	 */
	public static final String INIT_JDBC_SUCCESS = "初始化JDBC成功！";
	/**
	 * 初始化JDBC失败
	 */
	public static final String INIT_JDBC_ERROR = "初始化JDBC失败！";
	
}
