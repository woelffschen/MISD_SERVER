// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Menue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int menueId;
	@Column(nullable = false)
	String meal;

	@Column(nullable = false)
	boolean lactoseFree;
	@Column(nullable = false)
	boolean glutenFree;
	@Column(nullable = false)
	boolean fructoseFree;
	@Column(nullable = false)
	boolean sorbitFree;
	@Column(nullable = false)
	boolean vegan;
	@Column(nullable = false)
	boolean vegetarian;
	@Column(nullable = true)
	byte[] titlePic;
	@OneToOne(mappedBy = "menue")
	Event event;

	public Menue() {
	};

	public Menue(String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega,
			boolean vegee, byte[] t) {

		meal = name;
		lactoseFree = lactose;
		glutenFree = gluten;
		fructoseFree = fructose;
		sorbitFree = sorbit;
		vegan = vega;
		vegetarian = vegee;
		titlePic = t;

	}

	public int getMenueId() {
		return menueId;
	}

	public void setName(String n) {
		meal = n;
	}

	public String getName() {
		return meal;
	}

	public void setLactose(boolean n) {
		if (n) {
			lactoseFree = false;
		} else {
			lactoseFree = true;
		}
	}

	public boolean getLactose() {
		return lactoseFree;
	}

	public void setGluten(boolean n) {
		if (n) {
			glutenFree = false;
		} else {
			glutenFree = true;
		}
		;
	}

	public boolean getGluten() {
		return glutenFree;
	}

	public void setFructose(boolean n) {
		if (n) {
			fructoseFree = false;
		} else {
			fructoseFree = true;
		}
		;
	}

	public boolean getFructose() {
		return fructoseFree;
	}

	public void setSorbit(boolean n) {
		if (n) {
			sorbitFree = false;
		} else {
			sorbitFree = true;
		}
		;
	}

	public boolean getSorbit() {
		return sorbitFree;
	}

	public void setVegan(boolean n) {
		if (n) {
			vegan = false;
		} else {
			vegan = true;
		}
		;
	}

	public boolean getVegan() {
		return vegan;
	}

	public void setVegetarian(boolean n) {
		if (n) {
			vegetarian = false;
		} else {
			vegetarian = true;
		}
		;
	}

	public boolean getVegetarian() {
		return vegetarian;
	}

	// get and set userPic
	public void setTitlePic(byte[] t) {
		titlePic = t;
	}

	public byte[] getTitlePic() {
		return titlePic;
	}

}
