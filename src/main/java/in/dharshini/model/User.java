package in.dharshini.model;

public class User {
	private Integer userId;
	private String mailId;
	private String password;
	private String firstName;
	private Integer age;

	public User(String firstName, String mailId, String password, Integer age) {
		super();
		this.firstName = firstName;
		this.mailId = mailId;
		this.password = password;
		this.age = age;
	}

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

	public User(Integer userId, String firstName, Integer age) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.age = age;

	}

	public User(String mailId, String password) {
		this.mailId = mailId;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
