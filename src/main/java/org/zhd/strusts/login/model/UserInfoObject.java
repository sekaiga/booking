package org.zhd.strusts.login.model;

public class UserInfoObject {

	public static final String TABLE_USER_INFO = "user_info";
	public static final String USER_ID = "user_id";
	public static final String USERNAME = "username";
	public static final String PASSWD = "passwd";
	public static final String REFER_USER_ID = "refer_user_id";
	public static final String NICKNAME = "nickname";
	public static final String PHONE = "phone";
	public static final String NOTE = "note";
	public static final String STATUS = "status";
	

	private int userID;
	private String username;
	private String passwd;
	private String referUserID;
	private String nickname;
	private String phone;
	private String note;
	private int status;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getReferUserID() {
		return referUserID;
	}

	public void setReferUserID(String referUserID) {
		this.referUserID = referUserID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
