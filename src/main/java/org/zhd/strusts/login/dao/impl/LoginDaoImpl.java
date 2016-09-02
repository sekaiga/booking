package org.zhd.strusts.login.dao.impl;

import org.zhd.strusts.dao.JdbcBaseDaoImpl;
import org.zhd.strusts.login.dao.LoginDao;
import org.zhd.strusts.login.model.UserInfoObject;

public class LoginDaoImpl extends JdbcBaseDaoImpl implements LoginDao {

	public boolean login(String username, String passwd) {
		String sql = String.format("select count(*) from %s where %s = '%s' and %s = '%s'", UserInfoObject.TABLE_USER_INFO, UserInfoObject.USERNAME,
				username, UserInfoObject.PASSWD, passwd);
		logger.debug(sql);
		Integer num = queryTotalCount(sql, Integer.class);
		if (num == 1)
			return true;
		else
			return false;
	}

	public boolean register(UserInfoObject o) {
		String sqlPart = String.format("%s,%s,%s,%s,%s,%s,%s", UserInfoObject.USERNAME, UserInfoObject.PASSWD, UserInfoObject.REFER_USER_ID,
				UserInfoObject.PHONE, UserInfoObject.NOTE, UserInfoObject.STATUS,UserInfoObject.NICKNAME);
		String values = String.format("'%s','%s','%s','%s','%s','%s','%s'", o.getUsername(), o.getPasswd(), o.getReferUserID(),
				o.getPhone(), o.getNote(), o.getStatus(),o.getNickname());
		String sql = String.format("insert into %s (%s) values (%s)", UserInfoObject.TABLE_USER_INFO,sqlPart,values);
		return excuteInsert(sql);
	}
}
