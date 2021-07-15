package outerparkuser;

public class OuterparkUserVO {
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userMail;
	private String usertype;
	
	public OuterparkUserVO(String userId, String userPassword, String userName, String userNickname, String userMail,
			String usertype) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userMail = userMail;
		this.usertype = usertype;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "outerparkUserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userNickname=" + userNickname + ", userMail=" + userMail + ", usertype=" + usertype + "]";
	}
	
}
