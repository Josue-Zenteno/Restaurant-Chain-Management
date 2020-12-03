package A01.RestaurantChainManagement.domain;

import java.util.Vector;


public class Cooker {
	
	/************************Constructor***********************/
	public Cooker() {}
	
	/**********************Main functions**********************/
	public void prepareMeal() {//Iteration2
		TableWaiter tw = new TableWaiter();
		Vector<Integer> waitingForFoodTables = tw.getWaitingForFoodTables();
		int selectedTable;
		while(true) {
			selectedTable = tw.askForTable(waitingForFoodTables, "Waiting for food");
			if(selectedTable != -1) {
				if(selectedTable >= 0 && selectedTable<waitingForFoodTables.size()) {
					tw.advanceState(waitingForFoodTables.elementAt(selectedTable), 40);
					break;
				}
			}
		}
	}
	
}