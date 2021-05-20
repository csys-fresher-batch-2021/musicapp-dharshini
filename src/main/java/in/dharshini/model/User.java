package in.dharshini.model;

public class User {
	private String mailId;
	private String password;

	private String newMailId;
	
	public User(String password) {
		this.password = password;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMailId() {
		return mailId;
	}

	public String getPassword() {
		return password;
	}

	public String getNewMailId() {
		return newMailId;
	}

	public void setNewMailId(String newMailId) {
		this.newMailId = newMailId;
	}
}
