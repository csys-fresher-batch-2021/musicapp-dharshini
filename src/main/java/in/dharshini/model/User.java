package in.dharshini.model;

public class User {
	private Integer userId;
	private String mailId;
	private String password;

	public User(Integer userId, String mailId, String password) {
		super();
		this.userId = userId;
		this.mailId = mailId;
		this.password = password;
	}

	public User(String mailId) {
		super();
		this.mailId = mailId;
	}

	public User(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [mailId=" + mailId + ", password=" + password + "]";
	}
}
