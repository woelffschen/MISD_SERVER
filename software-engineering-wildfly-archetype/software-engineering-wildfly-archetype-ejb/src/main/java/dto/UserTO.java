// created by Sylvia & Daniel

package dto;

import java.awt.Image;

import dto.DataTransferObject;
import entities.Attendance;

public class UserTO extends DataTransferObject {
	
	private static final long serialVersionUID = 3440740273700082798L;
	
	//Attribute-Declaration 
	private int userId;
	private Image userPic;
	private String lastname;
	private String firstname;
	private String street;
	private int postalCode;
	private String city;
	private int age;
	private char gender;
	private String telephoneNumber;
	private boolean alcDrinks;
	
	Attendance status;
	
	//Parameterloser Konstruktor 
	public UserTO(){};
	
	
	public UserTO(String ln, String fn, String str, int plz, String c, int a,char g,Image u, String tel, boolean alc){

		super();
		lastname= ln;
		firstname= fn;
		street= str;
		postalCode= plz;
		city= c;
		age = a;
		gender=g;
		telephoneNumber= tel;
		alcDrinks= alc;
		userPic =u;
		
	}
	
	// get and set gender
	public void setGender(char n){
		gender = n;
		}
	
	public char getGender(){
		return gender;
	}
	
	//// get and set lastname
	public void setLastname(String l){
		lastname=l;
		
	}
	
	public String getLastname(){
		return lastname;
	}
	
	// get and set firstname
	public void setFirstname(String f){
		firstname=f;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	// get and set street
	public void setStreet(String s){
		street=s;
	}
	
	public String getStreet(){
		return street;
	}
	
	// get and set postalcode
	public void setPostalCode(int p){
		postalCode=p;
	}
	
	public int getPostalCode(){
		return postalCode;
	}
	
	// get and set city
	public void setCity(String c){
		city=c;
	}
	
	public String getCity(){
		return city;
	}
	
	// get and set age
	public void setAge(int a){
		age=a;
	}
		
	public int getAge(){
		return age;
	}
	
	// get and set telephoneNumber
	public void setTelephoneNumber(String t){
		telephoneNumber=t;
	}
	
	public String getTelephoneNumber(){
		return telephoneNumber;
	}
	
	// get and set alcDrinks
	public void setAlcDrinks(boolean a){
		alcDrinks=a;
	}
	
	public boolean getAlcDrinks(){
		return alcDrinks;
	}
		
	// get and set userPic
	public void setUserPic(Image u){
			userPic = u;
			}
		
	public Image getUserPic(){
			return userPic;
			}
	
}//End Class
