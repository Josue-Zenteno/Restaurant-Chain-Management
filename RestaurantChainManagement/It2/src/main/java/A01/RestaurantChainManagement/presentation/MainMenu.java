package A01.RestaurantChainManagement.presentation;

import java.util.Scanner;
import A01.RestaurantChainManagement.domain.ManagerEmployee;

public class MainMenu {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		int rol=0;
		int option = 0;
		System.out.println("Welcome to the Restaurant Chain Management system\n");
		do {
			System.out.println("Please choose an option from below\n"
					+ "\t[Option 1] Room Head\n"
					+ "\t[Option 2] Table Waiter\n"
					+ "\t[Option 3] Cooker\n"
					+ "\t[Option 0] Exit");
			rol= readOption(0,3);
			switch (rol) {
			case 1:
				do {
					System.out.println("\nYou have logged as Room Head\n"
							+ "\tSelect one option:\n"
							+ "\t[Option 1] Book a table\n"
							+ "\t[Option 0] Exit");
					option = readOption(0, 1);
					switch (option) {
						case 1: //Iteration1
							System.out.println("\nSelect the turn of the booking:\n"
									+ "\t[Option 1] First turn\n"
									+ "\t[Option 2] Second turn\n"
									+ "\t[Option 3] Third turn");
							int turn = readOption(1, 3);
							System.out.println("\nSelected turn: "+ turn + "º");
							String[] AvailableTables = ManagerEmployee.checkAvailableTables();
							
							if(AvailableTables[0].equals("false")) {
								System.out.println("All our tables are reserved");
								
							}else if(AvailableTables[0].equals("true")) {
								System.out.println("Select the table to book:"+AvailableTables[1]);
								int selectedTable = readOption(1, Integer.parseInt(AvailableTables[2]));
								
								String search = "\n"+selectedTable+". Table with ID ";
								int tableid = Character.getNumericValue(AvailableTables[1].charAt(AvailableTables[1].indexOf(search)+search.length()));
								System.out.println("The id of the selected table is: "+tableid);  //Obtaining the id of the selected table
									
									if(ManagerEmployee.checkAdvanceState(tableid,120)) {
										System.out.println("Table booked, we will be waiting for you");
									}else{
										System.out.println("There was an error when booking the table");
									}
					            }
		
							break;
						case 0:
							System.out.println("You have logged out as Room Head correctly\n");
							break;
					}
				}while (option != 0);
				break;
				
			case 2: //Iteration2
				do {
					System.out.println("\nYou have logged as a Table Waiter\n"
							+ "\n Select one option:"
							+ "\n [Option 1] Make an order"
							+ "\n [Option 2] Calculate Statistics"
							+ "\n [Option 0] Exit");
					option = readOption(0, 2);
					switch (option) {
						case 1:
							ManagerEmployee.attendTable();
							ManagerEmployee.makeOrder();
							break;
						case 2:
							ManagerEmployee.getTakeCommandStats();
							ManagerEmployee.getMealPreparationStats();
							//TODO in future iterations
							//ManagerEmployee.getDeliveryNoteStats();  
							//ManagerEmployee.getPreparationStats();
							break;
						case 0:
							System.out.println("You have logged out as Table Waiter correctly\n");
							break;
					}
				}while (option != 0);
				break;
				
			case 3: //Iteration2
				do {
					System.out.println("\nYou have logged as a Cooker\n"
							+ "\n Select one option:"
							+ "\n [Option 1] Notify that meal is prepared"
							+ "\n [Option 0] Exit");
					option = readOption(0, 1);
					switch (option) {
					case 1:
						ManagerEmployee.prepareMeal();
						break;
					case 0:
						System.out.println("You have logged out as Cooker correctly\n");
					}
				}while (option != 0);
				break;
				
			case 0:
				System.out.println("You have exited correctly");
				break;
			}
		}while (rol != 0);
		sc.close();
	}
	
	public static int readOption(int min, int max){ //Iteration1
		System.out.print("Option: ");
		int number = sc.nextInt();
			while(number < min || number > max) {
				System.out.println("You must enter a number between "+min+" and "+max);
				number = sc.nextInt();
			}
		return number;
	}
}
