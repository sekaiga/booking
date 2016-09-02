package org.zhd.strusts.login.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.zhd.strusts.util.HTTPUtil;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	
	private String username;
	private String password;
	private String editVerifyCode;
	
	public String login(){
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("editVerifyCode:"+editVerifyCode);
		String res = "ok";
		HttpServletResponse response = ServletActionContext.getResponse();
		HTTPUtil.sendResponse(response, res);
		return null;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEditVerifyCode() {
		return editVerifyCode;
	}

	public void setEditVerifyCode(String editVerifyCode) {
		this.editVerifyCode = editVerifyCode;
	}
}
