package org.zhd.strusts.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcBaseDaoImpl extends JdbcDaoSupport implements JdbcBaseDao{

	@SuppressWarnings("rawtypes")
	public List querySimpleTable(String sql) {
		try {
			return this.getJdbcTemplate().queryForList(sql);
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return null;
		}

	}
	
	public <T>T queryTotalCount(String sql,Class<T> clazz){
		try {
			return this.getJdbcTemplate().queryForObject(sql,clazz);
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return null;
		}
	}
	
	public SqlRowSet queryInfoBySql(String sql){
		try {
			return this.getJdbcTemplate().queryForRowSet(sql);
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return null;
		}
	}
	
	public boolean excuteSql(String sql) {
		try {
			this.getJdbcTemplate().execute(sql);
			return true;
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return false;
		}

	}
	
	public boolean excuteInsert(String sql) {
		try {
			this.getJdbcTemplate().update(sql);
			return true;
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return false;
		}

	}
	
	public boolean excuteDelete(String sql) {
		try {
			this.getJdbcTemplate().update(sql);
			return true;
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return false;
		}

	}
	
	public boolean excuteUpdate(String sql) {
		try {
			this.getJdbcTemplate().update(sql);
			return true;
		} catch (Exception ex) {
			logger.error("执行查询语句:" + sql + " 错误：" + ex.getMessage());
			logger.debug(ex);
			return false;
		}

	}
	
	public int[] batchUpdate(String sql, final List<String[]> dataSet) {  
        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            public int getBatchSize() {  
                return dataSet.size();  
            }  
    
            public void setValues(PreparedStatement psmt, int i) {  
                 String[] obj = dataSet.get(i);  
                 try {  
                     for (int j = 0; j < obj.length; j++) {  
                         psmt.setString(j + 1, obj[j]);  
                     }  
                 } catch (Exception e) {  
                     e.printStackTrace();  
                 }  
            }  
        };  
        return getJdbcTemplate().batchUpdate(sql, setter);  
	}
	
	
}
