package com.github.dbplug;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

/** 
  * @ClassName  DBPlugUtil
  * @Description  TODO(DBPlug) 
  * @Author  liuzy
  * @Date  2018年3月21日 下午2:46:19  
  */

public class DBPlugUtil {

	private DBConnection dbconn = null;
	
	/**
	 * 构造函数
	 * @param dbSource
	 */
	public DBPlugUtil(Map<String, String> baseMap, Map<String, Integer> subJoinMap){
		dbconn = new DBConnection(baseMap, subJoinMap);
	}
	
	public DBPlugUtil() {
		super();
	}
	
	
	
	

	/**
	 * 测试连接
	 * mysql、oracle、sqlServer 通用
	 * 
	 */
	public static Result testConn(Map<String, String> baseMap, Map<String, Integer> subJoinMap) {
		Result result = null;
		DBConnection conTemp = new DBConnection();
		if(baseMap.get("connType").equals("1")) {
			result = conTemp.initC3p0ConnPool(baseMap, subJoinMap);
		}else {
			result = conTemp.initConnection(baseMap);
		}
		Connection conn = conTemp.getConnection();
		//关闭数据库连接 
        DbUtils.closeQuietly(conn); 
		return result;
	}
	
	/**
	 * 查询多条记录
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午4:56:17
	 */
	public Result queryList(String sql){
		QueryRunner qr = new QueryRunner();
		List<Map<String,Object>> list = null;
		Connection conn = dbconn.getConnection();
		try {
			list = qr.query(conn, sql, new MapListHandler());
			return Result.build(MsgConstant.RESULT_CODE_SUCCES, MsgConstant.SUCCESS, list);
		} catch (SQLException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.ERROR, sql, e.getMessage());
		} finally {
			// 关闭数据库连接 
			DbUtils.closeQuietly(conn); 
		}
	}
	
	/**
	 * 查询一条记录
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午4:56:34
	 */
	public Result queryOne(String sql){
		QueryRunner qr = new QueryRunner();
		Map<String,Object> map = null;
		Connection conn = dbconn.getConnection();
		try {
			map = qr.query(conn, sql, new MapHandler());
			return Result.build(MsgConstant.RESULT_CODE_SUCCES, MsgConstant.SUCCESS, map);
		} catch (SQLException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.ERROR, sql, e.getMessage());
		} finally {
			// 关闭数据库连接
			DbUtils.closeQuietly(conn); 			 
		}
	}
	
	/**
	 * 添加、修改、删除
	 * 
	 * @Author  liuzy
	 * @Date  2018年3月21日 下午5:09:43
	 */
	public Result change(String sql){
		QueryRunner qr = new QueryRunner();
		Connection conn = dbconn.getConnection();
		try {
			qr.update(conn, sql);
			return Result.build(MsgConstant.RESULT_CODE_SUCCES, MsgConstant.SUCCESS);
		} catch (SQLException e) {
			return Result.build(MsgConstant.RESULT_CODE_ERROR, MsgConstant.ERROR, sql, e.getMessage());
		} finally {
			// 关闭数据库连接 
			DbUtils.closeQuietly(conn); 			
		}
	}
	
}
