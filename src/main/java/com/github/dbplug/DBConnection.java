package com.github.dbplug;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	public DBConnection(DBSource source){
		if(source.getConnType()!=null && source.getConnType()==1) {
			initC3p0ConnPool(source);
		}else {
			initConnection(source);
		}
	}

	/**
	 * 初始化C3P0连接
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午3:31:48
	 */
	public Result initC3p0ConnPool(DBSource source) {
		try {
			Class.forName(source.getDriverClass());
        	cpds = new ComboPooledDataSource();  
        	cpds.setDriverClass(source.getDriverClass());// 驱动器  
            cpds.setJdbcUrl(source.getJdbcUrl()); // 数据库url  
            cpds.setUser(source.getUser()); // 用户名  
            cpds.setPassword(source.getPassword()); // 密码  
            
            Integer initialPoolSize = source.getInitialPoolSize();
            Integer minPoolSize = source.getMinPoolSize();
            Integer maxPoolSize = source.getMaxPoolSize();
            Integer acquireIncrement = source.getAcquireIncrement();
            Integer idleConnectionTestPeriod = source.getIdleConnectionTestPeriod();
            Integer checkoutTimeout = source.getCheckoutTimeout();
            Boolean testConnectionOnCheckout = source.getTestConnectionOnCheckout();
            
            cpds.setInitialPoolSize(initialPoolSize == null? 10 : initialPoolSize); // 初始化连接池大小  
            cpds.setMinPoolSize(minPoolSize == null? 5 : minPoolSize); // 最少连接数  
          	cpds.setMaxPoolSize(maxPoolSize == null? 50 : maxPoolSize); // 最大连接数  
          	cpds.setAcquireIncrement(acquireIncrement == null? 5 : acquireIncrement); // 连接数的增量  
          	cpds.setIdleConnectionTestPeriod(idleConnectionTestPeriod == null? 300 : idleConnectionTestPeriod); // 测连接有效的时间间隔  
          	cpds.setTestConnectionOnCheckout(testConnectionOnCheckout == null? false:testConnectionOnCheckout); // 每次连接验证连接是否可用  
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
	public Result initConnection(DBSource source) {
		try {
			Class.forName(source.getDriverClass());
			con = DriverManager.getConnection(source.getJdbcUrl(), source.getUser(), source.getPassword());
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
