package org.zhd.strusts.login.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.zhd.strusts.login.dao.LoginDao;
import org.zhd.strusts.login.model.UserInfoObject;
import org.zhd.strusts.login.service.LoginService;

@Service
public class LoginSeriveImpl implements LoginService{
	
	private static Logger logger = LogManager.getLogger();

	@Resource
	private LoginDao loginDao;

	public boolean login(String username) {
		return loginDao.login(username, username);
	}
	
	public boolean login(String username, String passwd) {
		return loginDao.login(username, passwd);
	}

	public boolean register(UserInfoObject o) {
		return loginDao.register(o);
	}

	public boolean register(String username, String referUserID, String nickname) {
		return false;
	}

	
	
	
}
