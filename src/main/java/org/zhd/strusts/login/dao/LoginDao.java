package org.zhd.strusts.login.dao;

import org.zhd.strusts.login.model.UserInfoObject;

public interface LoginDao {
	
	public boolean login(String username,String passwd);
	
	public boolean register(UserInfoObject o);
}
