package org.zhd.test.strusts;

import javax.annotation.Resource;

import org.junit.Test;
import org.zhd.strusts.login.model.UserInfoObject;
import org.zhd.strusts.login.service.LoginService;

public class LoginTest extends BaseTestCase{
	@Resource
	LoginService service;
	
	@Test
	public void testLogin(){
		System.out.println(service.login("123", "111"));
	}
	
	@Test
	public void testRegister(){
		UserInfoObject o = new UserInfoObject();
		o.setUsername("123");
		o.setReferUserID("123");
		o.setNickname("123");
		
		o.setPhone("123");
		o.setPasswd("123");
		o.setNote("");
		System.out.println(service.register(o));
	}
}
