package A01.RestaurantChainManagement.domain;

import A01.RestaurantChainManagement.persistance.IngredientDAO;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


@SuppressWarnings("resource")
public class TableWaiter extends Waiter {//Iteration2
	
	/************************Attributes************************/
	private IngredientDAO ingredientDAO;
	
	/************************Constructor***********************/
	public TableWaiter() {
		super();
		setIngredientDAO(new IngredientDAO());
	}
	
	/**********************Main functions**********************/
	public void attendTable() {
		Vector<Integer> busyTables = getBusyTables();
		if(busyTables.size() != 0) {
			int selectedTable;
			while(true) {
				selectedTable = askForTable(busyTables, "Busy");
				if(selectedTable != -1) {
					if(selectedTable >= 0 && selectedTable<busyTables.size()) {
						advanceState(busyTables.elementAt(selectedTable), 10);
						break;
					}
				}
			}
		}else {
			System.out.println("There are not Busy Tables to attend");
		}
	}
	
	public void makeOrder() {
		Vector<Integer> askingTables = getAskingTables();
		
		if(askingTables.size() != 0) {
			Vector<String> availableIngredients = getAvailableIng();
			Vector<String> menu = getMenu();
			int selectedTable;
			
			while(true) {
				selectedTable = askForTable(askingTables, "Asking");
				System.out.println("tableId: "+selectedTable);
				if(selectedTable != -1) {
					if(selectedTable >= 0 && selectedTable < askingTables.size()) {
						break;
					}
				}
			}
			
			while (true){
				Dish orderDish = askForDish(menu);
				if(tryToMakeAnOrder(availableIngredients, orderDish)) {
					advanceState(askingTables.elementAt(selectedTable), 15);
					break;
				}else {
					System.out.println("\nSorry there are not enough ingredients to prepare: "+orderDish.getName());
				}
			}
		}else {
			System.out.println("There are not Asking Tables to take a command");
		}
	}
	
	public void getTakeCommandStats() {
		Transaction tr = new Transaction();
		System.out.println("The average time of taking a command in this restaurant is: "+tr.getTakeCommandStats());
	}
	
	public void getMealPreparationStats() {
		Transaction tr = new Transaction();
		System.out.println("The average time of preparation in this restaurant is: "+tr.getMealPreparationStats());
	}
	
	public void getDeliveryNoteStats() {
		Transaction tr = new Transaction();
		System.out.println("The average time of delivering a note in this restaurant is: "+tr.getDeliveryNoteStats());
	}

	public void getPreparationStats() {
		Transaction tr = new Transaction();
		System.out.println("The average time of table preparation in this restaurant is: "+tr.getPreparationStats());
	}
	
	/*******************Auxiliary functions********************/
	public void advanceState(int tableID, int maxStateTime) {
		Random r = new Random();
		int time = r.nextInt(maxStateTime) + 1;
		
		Table t = new Table(tableID);
		t.read();
		t.setState(t.getState()+1);
		t.update();
		t.doTransaction(time);	
	}

	public boolean tryToMakeAnOrder(Vector<String> avbIngs, Dish orderDish) {
		String[] availableIngredients = new String[avbIngs.size()];
		for(int i=0; i<avbIngs.size(); i++) {
			availableIngredients[i] = avbIngs.elementAt(i);
		}
		return orderDish.isValid(availableIngredients);
	}

	public Vector<Integer> getBusyTables() {
		Table t = new Table();
		return t.getBusyTables();
	}
	
	public Vector<Integer> getAskingTables(){
		Table t = new Table();
		return t.getAskingTables();
	}
	
	public Vector<Integer> getWaitingForFoodTables(){
		Table t = new Table();
		return t.getWaitingForFoodTables();
	}
	
	public Vector<String> getAvailableIng() {
		getIngredientDAO().readAllAvailables();
		Vector<String> availableIngredients = getIngredientDAO().getIngredientsList(); 	
		return availableIngredients;
	}
	
	public Vector<String> getMenu() {
		Dish d = new Dish();
		return d.getMenu();
	}
		
	
	public int askForTable(Vector<Integer> returnedTables, String kind) {
		Scanner sc = new Scanner(System.in);
		int selectedTable = -1;
		
		System.out.println("\n[List of "+kind+" tables]\nChoose a table:");
		for(int i=0; i<returnedTables.size(); i++) {
			System.out.println("[Option: "+i+"] Table Nº"+returnedTables.elementAt(i));
		}
		
		try {
			System.out.print("Option: ");
			selectedTable = sc.nextInt();
		}catch(InputMismatchException e) {
			return -1;
		}
		return selectedTable;
	}
	
	public Dish askForDish(Vector<String> menu){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nChoose the dish of the menu:");
		for(int i=0;i<menu.size();i++) {
			System.out.println("[Option "+i+"]: "+menu.elementAt(i));
		}
		
		while(true) {
			try {
				System.out.print("Option: ");
				int selectedDish = sc.nextInt();
				if(selectedDish>=0 && selectedDish<menu.size()) {
					Dish d = new Dish(menu.elementAt(selectedDish));
					d.read();
					return d;
				}
			}catch(InputMismatchException e) {
				System.out.println("Choose a valid option");
			}
		}
	}
	
	public IngredientDAO getIngredientDAO() {
		return this.ingredientDAO;
	}

	public void setIngredientDAO(IngredientDAO ingredientDAO) {
		this.ingredientDAO = ingredientDAO;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}