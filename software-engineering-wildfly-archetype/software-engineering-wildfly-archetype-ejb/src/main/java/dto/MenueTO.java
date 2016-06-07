// @Author Sylvia & Daniel

package dto;

public class MenueTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private String meal;
	private int menueId;
	private boolean lactoseFree;
	private boolean glutenFree;
	private boolean fructoseFree;
	private boolean sorbitFree;
	private boolean vegan;
	private boolean vegetarian;	
	private byte[] titlePic;

	public MenueTO() {
	};

	public MenueTO(int menueId, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit,
			boolean vega, boolean vegee, byte[] t) {

		super();
		this.menueId = menueId;
		meal = name;
		lactoseFree = lactose;
		glutenFree = gluten;
		fructoseFree = fructose;
		sorbitFree = sorbit;
		vegan = vega;
		vegetarian = vegee;
		titlePic = t;

	}

	public void setMenueId(int menueId) {
		this.menueId = menueId;
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

	public void setTitlePic(byte[] t) {
		titlePic = t;
	}

	public byte[] getTitlePic() {
		return titlePic;
	}

}
