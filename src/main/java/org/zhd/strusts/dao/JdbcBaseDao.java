package org.zhd.strusts.dao;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface JdbcBaseDao {

	/**
	 * 单表查询，查询一批数据
	 * @param sql 查询语句
	 * @return 返回查询列表
	 */
	@SuppressWarnings("rawtypes")
	List querySimpleTable(String sql);
	
	/**
	 * 查询总记录数  
	 * @param sql 查询语句
	 * @param clazz 指定返回结果类型
	 * @return 返回查询结果
	 */
	<T>T queryTotalCount(String sql,Class<T> clazz);
	
	/**
	 * 查询一批数据
	 * @param sql 查询语句
	 * @param clazz 指定返回结果类型
	 * @return 返回查询结果
	 */
	SqlRowSet queryInfoBySql(String sql);
	
	/**
	 * 执行ddl语句
	 * @param sql 查询语句
	 * @return 返回执行结果
	 */
	boolean excuteSql(String sql);
	
	/**
	 * 执行插入语句
	 * @param sql 查询语句
	 * @return 返回执行结果
	 */
	boolean excuteInsert(String sql);
	
	/**
	 * 执行删除语句
	 * @param sql 查询语句
	 * @return 返回执行结果
	 */
	boolean excuteDelete(String sql);
	
	/**
	 * 执行修改语句
	 * @param sql 查询语句
	 * @return 返回执行结果
	 */
	boolean excuteUpdate(String sql);
	
	/**
	 * 执行修改语句
	 * @param sql 执行语句，不支持 命名参数，只能用 ? 代替
	 * @param dataSet
	 * @return 返回执行结果
	 */
	int[] batchUpdate(String sql, final List<String[]> dataSet);
	
}
