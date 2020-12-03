package A01.RestaurantChainManagement.domain;

import java.util.Vector;
import A01.RestaurantChainManagement.persistance.DishDAO;


public class Dish {//Iteration2
	
	/************************Attributes************************/
	private String Name;
	private String[] Ingredients;
	private DishDAO dishDAO;
	
	/************************Constructor***********************/
	public Dish() {
		setDishDAO(new DishDAO());
	}
	
	public Dish(String name) {
		setName(name);
		setDishDAO(new DishDAO());
	}
	
	/**********************Main functions**********************/
	public Vector<String> getMenu(){
		return getDishDAO().getMenu();
	}
	
	public boolean isValid(String[] availableIng) {
		boolean valid = false;
		int counter = 0;
		
		for(int i=0; i <getIngredients().length; i++) {
			for(int j=0; j<availableIng.length; j++) {
				if(getIngredients()[i].equals(availableIng[j])) {
					counter++;
					break;
				}
			}
		}
		
		if(counter == 5) {
			valid = true;
		}
		
		return valid;
	}
	/*******************Auxiliary functions********************/
	public void read() {
		dishDAO.read(this);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String[] getIngredients() {
		return Ingredients;
	}

	public void setIngredients(String[] ingredients) {
		Ingredients = ingredients;
	}
	
	public DishDAO getDishDAO() {
		return this.dishDAO;
	}

	public void setDishDAO(DishDAO dishDAO) {
		this.dishDAO = dishDAO;
	}
}