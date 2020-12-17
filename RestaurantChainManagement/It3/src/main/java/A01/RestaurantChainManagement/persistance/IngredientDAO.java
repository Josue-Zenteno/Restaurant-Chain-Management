package A01.RestaurantChainManagement.persistance;

import java.util.Vector;


public class IngredientDAO {//Iteration2
	
	/************************Attributes************************/
	private Vector<String> IngredientsList;
	
	/************************Constructor***********************/
	public IngredientDAO() {
		setIngredientsList(new Vector<String>());
	}
	
	/**********************Main functions**********************/
	public void readAllAvailables() {
		try {
			Vector<Vector<Object>> auxVector = Broker.getAgente().leer("SELECT Name FROM A01dbservice.Ingredients WHERE Stock > 0;");

			for(int i=0; i<auxVector.size(); i++) {
				getIngredientsList().add((String) auxVector.elementAt(i).elementAt(0));
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void removeIngredients(String[] ingredients) {
		try {
			for(int i=0; i<ingredients.length;i++) {
				Vector<Vector<Object>> stockVector=Broker.getAgente().leer("SELECT Stock FROM A01dbservice.Ingredients WHERE Name = '"+ingredients[i]+"';");
				int nuevoStock=((Integer) stockVector.elementAt(0).elementAt(0))-1;
				Broker.getAgente().cambiar("UPDATE A01dbservice.Ingredients SET Stock = "+nuevoStock+" WHERE Name = '"+ingredients[i]+"';");	
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	public void updateIngredients(String[] ingredients, int[] quantity) {
		try {
			for(int i=0; i<ingredients.length;i++) {
				Broker.getAgente().cambiar("UPDATE A01dbservice.Ingredients SET Stock = "+quantity[i]+" WHERE Name = '"+ingredients[i]+"';");	
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void readAllIngredientsNames() {
		try {
			Vector<Vector<Object>> auxVector = Broker.getAgente().leer("SELECT Name FROM A01dbservice.Ingredients;");

			for(int i=0; i<auxVector.size(); i++) {
				getIngredientsList().add((String) auxVector.elementAt(i).elementAt(0));
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	/*******************Auxiliary functions********************/
	public Vector<String> getIngredientsList() {
		return this.IngredientsList;
	}

	public void setIngredientsList(Vector<String> ingredientsList) {
		IngredientsList = ingredientsList;
	}
}