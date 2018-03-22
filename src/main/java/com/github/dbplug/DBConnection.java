package com.github.dbplug;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
  * @ClassName  DBConnection
  * @Description  TODO(数据库连接) 
  * @Author  liuzy
  * @Date  2018年3月21日 下午3:51:22  
  */

public class DBConnection {

	private ComboPooledDataSource cpds = null;
	private Connection con = null;
	
	public DBConnection() {
		super();
	}

	public DBConnection(Map<String, String> baseMap, Map<String, Integer> subJoinMap){
		if(baseMap.get("connType").equals("1")) {
			initC3p0ConnPool(baseMap, subJoinMap);
		}else {
			initConnection(baseMap);
		}
	}

	/**
	 * 初始化C3P0连接
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午3:31:48
	 */
	public Result initC3p0ConnPool(Map<String, String> baseMap, Map<String, Integer> subJoinMap) {
		try {
			Class.forName(baseMap.get("driverClass"));
        	cpds = new ComboPooledDataSource();  
			cpds.setDriverClass(baseMap.get("driverClass"));// 驱动器  
            cpds.setJdbcUrl(baseMap.get("jdbcUrl")); // 数据库url  
            cpds.setUser(baseMap.get("user")); // 用户名  
            cpds.setPassword(baseMap.get("password")); // 密码  
            
            Integer initialPoolSize = subJoinMap.get("initialPoolSize");
            Integer minPoolSize = subJoinMap.get("minPoolSize");
            Integer maxPoolSize = subJoinMap.get("maxPoolSize");
            Integer acquireIncrement = subJoinMap.get("acquireIncrement");
            Integer idleConnectionTestPeriod = subJoinMap.get("idleConnectionTestPeriod");
            Integer checkoutTimeout = subJoinMap.get("checkoutTimeout");
            cpds.setInitialPoolSize(initialPoolSize == null? 10 : initialPoolSize); // 初始化连接池大小  
            cpds.setMinPoolSize(minPoolSize == null? 5 : minPoolSize); // 最少连接数  
            cpds.setMaxPoolSize(maxPoolSize == null? 50 : maxPoolSize); // 最大连接数  
            cpds.setAcquireIncrement(acquireIncrement == null? 5 : acquireIncrement); // 连接数的增量  
            cpds.setIdleConnectionTestPeriod(idleConnectionTestPeriod == null? 300 : idleConnectionTestPeriod); // 测连接有效的时间间隔  
            cpds.setTestConnectionOnCheckout(false); // 每次连接验证连接是否可用  
            cpds.setCheckoutTimeout(checkoutTimeout == null? 2000 : checkoutTimeout);//单位毫秒。
			con= cpds.getConnection();
			return Result.build(MsgConstant.RESULT_CODE_SUCCES, MsgConstant.INIT_C3P0_SUCCESS);
		} catch (SQLException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.INIT_C3P0_ERROR, e.getMessage());
		} catch (PropertyVetoException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.INIT_C3P0_ERROR, e.getMessage());
		} catch (ClassNotFoundException e) {
			return  Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.LOAD_DRIVER_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 初始化JDBC连接
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午3:31:48
	 */
	public Result initConnection(Map<String, String> baseMap) {
		try {
			Class.forName(baseMap.get("driverClass"));
			con = DriverManager.getConnection(baseMap.get("jdbcUrl"), baseMap.get("user"), baseMap.get("password"));
			return Result.build(MsgConstant.RESULT_CODE_SUCCES, MsgConstant.INIT_JDBC_SUCCESS);
		} catch (SQLException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.INIT_JDBC_ERROR, e.getMessage());
		} catch (ClassNotFoundException e) {
			return  Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.LOAD_DRIVER_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 获取连接对象
	 * 为dbutils提供连接对象
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午4:01:41
	 */
	public Connection getConnection(){
		return con;
	}
		
}
