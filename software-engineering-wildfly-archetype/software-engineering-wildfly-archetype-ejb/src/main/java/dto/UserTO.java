// @Author Sylvia & Daniel

package dto;

public class UserTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int userId;
	private byte[] userPic;
	private String lastname;
	private String firstname;
	private String street;
	private int postalCode;
	private String city;
	private int age;
	private char gender;
	private String telephoneNumber;
	private boolean alcDrinks;

	public UserTO() {
	};

	public UserTO(int userId, String ln, String fn, String str, int plz, String c, int a, char g, byte[] u, String tel,
			boolean alc) {

		super();
		this.userId = userId;
		lastname = ln;
		firstname = fn;
		street = str;
		postalCode = plz;
		city = c;
		age = a;
		gender = g;
		telephoneNumber = tel;
		alcDrinks = alc;
		userPic = u;

	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId(int userId) {
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

	public void setStreet(String s) {
		street = s;
	}

	public String getStreet() {
		return street;
	}

	public void setPostalCode(int p) {
		postalCode = p;
	}

	public int getPostalCode() {
		return postalCode;
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

	public void setTelephoneNumber(String t) {
		telephoneNumber = t;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setAlcDrinks(boolean a) {
		alcDrinks = a;
	}

	public boolean getAlcDrinks() {
		return alcDrinks;
	}

	public void setUserPic(byte[] u) {
		userPic = u;
	}

	public byte[] getUserPic() {
		return userPic;
	}

//	public User getPublicUserData() {
//		return user.getUserId();
//		return lastname;
//		return firstname;
//		return city;
//		return age;
//		return gender;
//		return telephoneNumber;
//		return alcDrinks;
//		return userPic;
//		
//	}
// strg shift c alles aus oder einkommentieren
	
}
