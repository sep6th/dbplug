# dbplug
基于dbutils（MapHandler、MapListHandler）的操作数据库工具(支持JDBC和C3P0 POOL)

用途：项目中需要连接其他数据库（目前支持MySQL、ORACLE、SQL Server），对其他数据库进行增删改查操作。

例子：

```
   /**
    * 注意：map的key不能有误，且确保所有的key都放入map中。
    * baseMap ：基本属性；
    * subJoinMap ：c3p0的附加属性；
    * 
    * 其中：connType：1：c3p0 pool；2：jdbc
    */
  Source source = sourceSrv.queryById(sourceId);
 
  Map<String, String> baseMap = new HashMap<String, String>();
	baseMap.put("driverClass", source.getDriver());
	baseMap.put("jdbcUrl", source.getUrl());
	baseMap.put("user", source.getUsername());
	baseMap.put("password", source.getPassword());
	baseMap.put("connType", String.valueOf(source.getConnType()));
		
	Map<String, Integer> subJoinMap = new HashMap<String, Integer>();
	subJoinMap.put("initialPoolSize", source.getCountNum());
	subJoinMap.put("minPoolSize", source.getMinConnum());
	subJoinMap.put("maxPoolSize", source.getMaxConnum());
	subJoinMap.put("acquireIncrement", source.getConnCircle());
	subJoinMap.put("idleConnectionTestPeriod", source.getFreeTime());
	subJoinMap.put("checkoutTimeout", source.getOutTime());
	
	DBPlugUtil dbplug = new DBPlugUtil(baseMap, subJoinMap);
	/**
	 * 定义sql，作为方法参数传入
	 */
	String sql = "select "+resource.getColumns()+" from "+ resource.getTableName();
	Result result = dbplug.queryList(sql);
	
```
    
