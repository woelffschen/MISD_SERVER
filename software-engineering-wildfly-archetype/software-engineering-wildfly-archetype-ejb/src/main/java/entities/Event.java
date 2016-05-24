// created by Sylvia & Daniel

package entities;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Attribute-Declaration 
	@Id @GeneratedValue
	int eventId;
	@Column(nullable =false)
	Menue menue;
	@Column(nullable =false)
	int minAge;
	@Column(nullable =false)
	int maxAge;
	//gender(enum[f,m,b])
	@Column(nullable =false)
	String eventStreet;
	@Column(nullable =false)
	int eventPostalCode;
	@Column(nullable =false)
	String eventCity;
	//User eventOwner;
	@Column(nullable =false)
	DateTimeAtCreation eventDateTime;
	@Column(nullable =true)
	String comments;
	Menue m;
	//eventStatus(enum);

	//Parameterloser Konstruktor 
	public Event(){};

	
	public Event(Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,String com){
		
		//mit Transaktion
		menue= m;
		minAge= min;
		maxAge= max;
		eventStreet= street;
		eventPostalCode= plz;
		eventCity= city;	
		eventDateTime= dateTime;
		comments= com;
		
	}//End Constructor
	
	public void alterEvent(){
		
	}
	
	public void deleteEvent(){
		
	}
	
	public void filterCity(){
		
	}
	
//get Id	
	public int getId(int userId){
		return eventId;
	}

//get Menue	
	public int getMenueById(){
		return menue.getMenueById();
	}
// get and set minAge	
	public void setMinAge(int i){
		minAge=i;
	}
	
	public int getMinAge(){
		return minAge;
	}
// get and set maxAge
	public void setMaxAge(int i){
		maxAge=i;
	}
	
	public int getMaxAge(){
		return maxAge;
	}
// get and set eventStreet	
	public void setEventStreet(String i){
		eventStreet=i;
	}
	
	public String getEventStreet(){
		return eventStreet;
	}
// get and set eventPostalCode	
	public void setEventPostalCode(int i){
		eventPostalCode=i;
	}
	
	public int geteventPostalCode(){
		return eventPostalCode;
	}
// get and set eventCity	
	public void setEventCity(String i){
		eventCity=i;
	}
	
	public String getEventCity(){
		return eventCity;
	}
// get and set eventDateTime	
	public void setEventDateTime(DateTimeAtCreation i){
		eventDateTime=i;
	}
	
	public DateTimeAtCreation getEventDateTime(){
		return eventDateTime;
	}
// get and set comments	
	public void setComments(String i){
		comments=i;
	}
	
	public String getComments(){
		return comments;
	}
	
		// alter Menue
		public void alterMenue(boolean f, boolean g, boolean l,String n, boolean s, boolean v, boolean veg){
			m.getMenueById();
			m.setFructose(f);
			m.setGluten(g);
			m.setLactose(l);
			m.setName(n);
			m.setSorbit(s);
			m.setVagan(v);
			m.setVegetarian(veg);
		}
		
		//create Menue
		public void createMenue(boolean f, boolean g, boolean l,String n, boolean s, boolean v, boolean veg){
			m.setFructose(f);
			m.setGluten(g);
			m.setLactose(l);
			m.setName(n);
			m.setSorbit(s);
			m.setVagan(v);
			m.setVegetarian(veg);
		}
	
	

}// end Event
