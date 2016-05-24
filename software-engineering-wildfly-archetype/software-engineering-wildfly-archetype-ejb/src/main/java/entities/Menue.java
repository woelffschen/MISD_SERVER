// created by Sylvia & Daniel

package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Menue implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//Attribute-Declaration 
	@Column(nullable =false)
	String meal;
	@Id @GeneratedValue
	int menueId;
	@Column(nullable =false)
	boolean lactoseFree;
	@Column(nullable =false)
	boolean glutenFree;
	@Column(nullable =false)
	boolean fructoseFree;
	@Column(nullable =false)
	boolean sorbitFree;
	@Column(nullable =false)
	boolean vegan;
	@Column(nullable =false)
	boolean vegetarian;
//-------------------------------------------------------------------------------	

	
	//Parameterloser Konstruktor 
	public Menue(){};
	
	public Menue(String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega, boolean vegee){
	
	meal=name;
	lactoseFree= lactose;
	glutenFree= gluten; 
	fructoseFree= fructose;
	sorbitFree= sorbit;
	vegan= vega;
	vegetarian= vegee;
		
	}//End Constructor
	
	public int getMenueById(){
		return menueId;
	}
	
//name
	public void setName(String n){
		meal=n;
	}
	
	public String getName(){
		return meal;
	}
//lactose
	public void setLactose(boolean n){
		if(n){
		lactoseFree=false;
		}else{
		lactoseFree=true;	
		}
	}
	
	public boolean getLactose(){
		return lactoseFree;
	}
//gluten	
	public void setGluten(boolean n){
		if(n){
			glutenFree=false;
			}else{
			glutenFree=true;	
			};
	}
	
	public boolean getGluten(){
		return glutenFree;
	}
//fructose	
	public void setFructose(boolean n){
		if(n){
			fructoseFree=false;
			}else{
			fructoseFree=true;	
			};
	}
	
	public boolean getFructose(){
		return fructoseFree;
	}
//sorbit	
	public void setSorbit(boolean n){
		if(n){
			sorbitFree=false;
			}else{
			sorbitFree=true;	
			};
	}
	
	public boolean getSorbti(){
		return sorbitFree;
	}
//vegan	
	public void setVagan(boolean n){
		if(n){
			vegan=false;
			}else{
			vegan=true;	
			};
	}
	
	public boolean getVegan(){
		return vegan;
	}
//vegetarian	
	public void setVegetarian(boolean n){
		if(n){
			vegetarian=false;
			}else{
				vegetarian=true;	
			};
	}
	
	public boolean getVegetarian(){
		return vegetarian;
	}
	
	
}//End Class
