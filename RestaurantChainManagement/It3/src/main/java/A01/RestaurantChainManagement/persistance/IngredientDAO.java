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
			Vector<Vector<Object>> auxVector = Broker.getAgente().leer("SELECT Name FROM A01dbservice.Ingredients WHERE Availability = 1;");

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