package com.github.dbplug;

/** 
  * @ClassName  DBSource
  * @Description  TODO(数据源) 
  * @Author  liuzy
  * @Date  2018年3月26日 下午2:38:46  
  */

public class DBSource {

	private String driverClass;
	private String jdbcUrl;
	private String user;
	private String password;
	private Integer connType;
	private Integer initialPoolSize;
	private Integer minPoolSize;
	private Integer maxPoolSize;
	private Integer acquireIncrement;
	private Integer idleConnectionTestPeriod;
	private Integer checkoutTimeout;
	private Boolean testConnectionOnCheckout;
	
	public DBSource() {
		super();
	}
	

	public DBSource(String driverClass, String jdbcUrl, String user, String password) {
		super();
		this.driverClass = driverClass;
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.password = password;
	}



	public DBSource(String driverClass, String jdbcUrl, String user, String password, Integer connType,
			Integer initialPoolSize, Integer minPoolSize, Integer maxPoolSize, Integer acquireIncrement,
			Integer idleConnectionTestPeriod, Integer checkoutTimeout, Boolean testConnectionOnCheckout) {
		super();
		this.driverClass = driverClass;
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.password = password;
		this.connType = connType;
		this.initialPoolSize = initialPoolSize;
		this.minPoolSize = minPoolSize;
		this.maxPoolSize = maxPoolSize;
		this.acquireIncrement = acquireIncrement;
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
		this.checkoutTimeout = checkoutTimeout;
		this.testConnectionOnCheckout = testConnectionOnCheckout;
	}



	public String getDriverClass() {
		return driverClass;
	}



	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}



	public String getJdbcUrl() {
		return jdbcUrl;
	}



	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getConnType() {
		return connType;
	}



	public void setConnType(Integer connType) {
		this.connType = connType;
	}



	public Integer getInitialPoolSize() {
		return initialPoolSize;
	}



	public void setInitialPoolSize(Integer initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}



	public Integer getMinPoolSize() {
		return minPoolSize;
	}



	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}



	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}



	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}



	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}



	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}



	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}



	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}



	public Integer getCheckoutTimeout() {
		return checkoutTimeout;
	}



	public void setCheckoutTimeout(Integer checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
	}



	public Boolean getTestConnectionOnCheckout() {
		return testConnectionOnCheckout;
	}



	public void setTestConnectionOnCheckout(Boolean testConnectionOnCheckout) {
		this.testConnectionOnCheckout = testConnectionOnCheckout;
	}
	
	
	
	
}
