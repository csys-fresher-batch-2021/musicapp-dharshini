package in.dharshini.model;

public class User {
	private String mailId;
	private String password;

	public User(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
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
