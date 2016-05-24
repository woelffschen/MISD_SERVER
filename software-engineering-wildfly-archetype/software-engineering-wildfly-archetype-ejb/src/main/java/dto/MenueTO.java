// created by Sylvia & Daniel

package dto;

import dto.DataTransferObject;

public class MenueTO extends DataTransferObject {
	
	private static final long serialVersionUID = 3440740273700082798L;

	//Attribute-Declaration 
	private String meal;
	private int menueId;
	private boolean lactoseFree;
	private boolean glutenFree;
	private boolean fructoseFree;
	private boolean sorbitFree;
	private boolean vegan;
	private boolean vegetarian;
//-------------------------------------------------------------------------------	

	
	//Parameterloser Konstruktor 
	public MenueTO(){};
	
	public MenueTO(String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega, boolean vegee){
	
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
