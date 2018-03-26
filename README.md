# dbplug
基于dbutils（MapHandler、MapListHandler）的操作数据库工具(支持JDBC和C3P0 POOL)

用途：项目中需要连接其他数据库（目前支持MySQL、ORACLE、SQL Server），对其他数据库进行增删改查操作,包括查询表字段、数据库所有表名称等。
     只要是你一条SQL查出的任何结果集，dbplug都能将操作结果返回给你。

例子：

```
   //第一步：
   public class DBPlugSource extends DBSource {}
   
   //第二步：

   /**
    *
    * 其中：connType：1：c3p0 pool；2：jdbc
    */
  Source source = sourceSrv.queryById(sourceId);
  
  DBPlugSource dbpsource = new DBPlugSource();
  dbpsource.setDriverClass(source.getDriver());
  dbpsource.setJdbcUrl(source.getUrl());
  dbpsource.setUser(source.getUsername());
  dbpsource.setPassword(source.getPassword());
  dbpsource.setConnType(source.getConnType());
  dbpsource.setInitialPoolSize(source.getCountNum());
  dbpsource.setMinPoolSize(source.getMinConnum());
  dbpsource.setMaxPoolSize(source.getMaxConnum());
  dbpsource.setAcquireIncrement(source.getConnCircle());
  dbpsource.setIdleConnectionTestPeriod(source.getFreeTime());
  dbpsource.setCheckoutTimeout(source.getOutTime());

  DBPlugUtil dbplug = new DBPlugUtil(dbpsource);
  /**
   * 定义sql，作为方法参数传入
   */
  String sql = "select "+resource.getColumns()+" from "+ resource.getTableName();
  Result result = dbplug.queryList(sql);
	
```
    
