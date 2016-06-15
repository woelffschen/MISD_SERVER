package dto;

public class PublicUserTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int userId;
	private String lastname;
	private String firstname;
	private String city;
	private int age;
	private char gender;


	public PublicUserTO() {
	};

	public PublicUserTO(int userId, String ln, String fn, String c, int a, char g) {

		super();
		this.userId = userId;
		lastname = ln;
		firstname = fn;
		city = c;
		age = a;
		gender = g;

	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setLastname(String l) {
		lastname = l;

	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String f) {
		firstname = f;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setCity(String c) {
		city = c;
	}

	public String getCity() {
		return city;
	}

	public void setAge(int a) {
		age = a;
	}

	public int getAge() {
		return age;

	}

	public void setGender(char n) {
		gender = n;
	}

	public char getGender() {
		return gender;
	}




}