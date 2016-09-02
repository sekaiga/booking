package org.zhd.strusts.login.service;

import org.zhd.strusts.login.model.UserInfoObject;

public interface LoginService {

	public boolean login(String username);

	public boolean login(String username, String passwd);

	public boolean register(UserInfoObject o);

	public boolean register(String username, String referUserID, String nickname);
}
