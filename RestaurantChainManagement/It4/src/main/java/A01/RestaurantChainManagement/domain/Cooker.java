package A01.RestaurantChainManagement.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import A01.RestaurantChainManagement.persistance.IngredientDAO;


public class Cooker {
	private IngredientDAO ingredientDAO;//Iteration3
	private Dish dishToPrepare;//Iteration3
	/************************Constructor***********************/
	public Cooker() {
		dishToPrepare = null;
		ingredientDAO = new IngredientDAO();
	}
	
	/**********************Main functions**********************/
	public int prepareMeal() {//Iteration2 with extras of iteration3, and iteration 4
		if(dishToPrepare != null) {	
			TableWaiter tw = new TableWaiter();
			Vector<Integer> waitingForFoodTables = tw.getWaitingForFoodTables();
			int selectedTable;
			while(true) {
				selectedTable = tw.askForTable(waitingForFoodTables, "Waiting for food");
				if(selectedTable != -1) {
					if(selectedTable >= 0 && selectedTable<waitingForFoodTables.size()) {
						ingredientDAO.removeIngredients(dishToPrepare.getIngredients());
						tw.advanceState(waitingForFoodTables.elementAt(selectedTable), 40); //Setting state to served (5)
						
						//iteration4 
						
						tw.advanceState(waitingForFoodTables.elementAt(selectedTable), 60); //Setting state to Waiting for bill (6), done automatically
						return 0;
					}
				}
			}
		}else return -1;
	}
	
	public void makeForecast() {//Iteration3
		Dish d = new Dish();
		Dish[] dishes = d.getDishes();
		ingredientDAO.readAllIngredientsNames();
		String[] ingredients = ingredientDAO.getIngredientsList().toArray(new String[ingredientDAO.getIngredientsList().size()]);
		int[] quantities =  new int [ingredients.length];
		Map<String,Integer> correspondency = new HashMap<String,Integer>();
		for(int i=0;i<ingredients.length;i++)
			correspondency.put(ingredients[i], i);
		for(int i=0;i<dishes.length;i++)
			for(int k=0;k<10;k++)
				for(String ingredient:dishes[i].getIngredients())
					quantities[correspondency.get(ingredient.trim())]++;

		ingredientDAO.updateIngredients(ingredients,quantities);
	}
	public void setDish(Dish dish) {//Iteration3
		dishToPrepare = dish;
	}
}