// created by Sylvia & Daniel

package entities;

import java.awt.Image;
import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity  
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Attribute-Declaration 
	@Id @GeneratedValue
	int userId;
	@Column(nullable =true)
	Image userPic;
	@Column(nullable =false)
	String lastname;
	@Column(nullable =false)
	String firstname;
	@Column(nullable =false)
	String street;
	@Column(nullable =false)
	int postalCode;
	@Column(nullable =false)
	String city;
	@Column(nullable =false)
	int age;
	@Column(nullable =false)
	char gender;
	String telephoneNumber;
	boolean alcDrinks;
	
	Attendance status;
	
	//Parameterloser Konstruktor 
	public User(){};
	
	
	public User(String ln, String fn, String str, int plz, String c, int a, String tel, boolean alc, Image u, char g){


		lastname= ln;
		firstname= fn;
		street= str;
		postalCode= plz;
		city= c;
		age = a;
		telephoneNumber= tel;
		alcDrinks= alc;
		userPic=u;
		gender=g;
		
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
	
	//get User
	public int getUserById(){
		return userId;
	}
		
}//End Class
