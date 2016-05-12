package MISD.Entities;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity  
public class User implements Serializable {
	//created by Sylvia/ Daniel
	
	private static final long serialVersionUID = 1L;
	
	//Attribute-Declaration 
	@Id @GeneratedValue
	int userId;
	//userpicture;
	//titlepicture;
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
	//gender(enum[f,m,b]);
	@Column(nullable =false)
	int age;
	String telephoneNumber;
	// loveMeals(ArrayList(String))
	// hateMeals(ArrayList(String))
	boolean alcDrinks;
	
	Attendance status.;
	
	//Enums bearbeiten
	
	//Parameterloser Konstruktor 
	public User(){};
	
	
	public User(String ln, String fn, String str, int plz, String c, int a, String tel, boolean alc){


		lastname= ln;
		firstname= fn;
		street= str;
		postalCode= plz;
		city= c;
		age = a;
		telephoneNumber= tel;
		alcDrinks= alc;
		
	}
	
	public void deleteUser(){
		
	}
	
	public User getPublicUserData(){
		
		return null;
	}

	public void logInUser(){
		
	}
	
	public void logOutUser(){
		
	}
	
	public void registerUser(){
		
	}
	
	
}//End Class
