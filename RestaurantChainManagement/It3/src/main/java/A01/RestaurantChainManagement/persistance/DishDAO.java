package A01.RestaurantChainManagement.persistance;

import java.util.Vector;

import A01.RestaurantChainManagement.domain.*;


public class DishDAO {//Iteration2
	
	/************************Constructor***********************/
	public DishDAO() {}
	
	/**********************Main functions**********************/
	public void read(Dish d) {
		try {
			String[] ingredients = new String[5];
			Vector<Vector<Object>> auxVector = Broker.getAgente().leer("SELECT * FROM A01dbservice.Dishes WHERE Name = '"+d.getName()+"';");
			
			for(int i=0; i<ingredients.length; i++) {
				ingredients[i] = (String) auxVector.elementAt(0).elementAt(i+1);
			}
			d.setIngredients(ingredients);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Vector<String> getMenu(){
		Vector<String> menu = new Vector<String>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT Name FROM A01dbservice.Dishes;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			menu.add((String) dbVector.elementAt(i).elementAt(0));
		}
		return menu;
	}
	
	public Dish[] getDishes() {
		Vector<Dish> dishes = new Vector<Dish>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT * FROM A01dbservice.Dishes;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			Dish dish = new Dish((String)dbVector.elementAt(i).elementAt(0));
			String[] ingredients = new String[5];
			for(int j=0; j<ingredients.length; j++) {
				ingredients[i] = (String) dbVector.elementAt(i).elementAt(j+1);
			}
			dish.setIngredients(ingredients);
			dishes.add(dish);
		}
		
		return dishes.toArray(new Dish[dishes.size()]);
	}
}