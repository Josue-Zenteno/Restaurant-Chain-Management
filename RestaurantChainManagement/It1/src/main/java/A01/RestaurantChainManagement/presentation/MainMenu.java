package A01.RestaurantChainManagement.presentation;
import java.util.Scanner;

import A01.RestaurantChainManagement.domain.ManagerEmployee;

public class MainMenu {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int rol=0;
		int option = 0;
		do {
			System.out.println("Welcome to the Restaurant Chain Management system\n"
					+ "Please choose an option from below\n"
					+ "1) Room Head\n"
					+ "2) Table Waiter\n"
					+ "0) Exit");
			rol= readOption(0,2);
			switch (rol) {
			case 1:
				do {
				System.out.println("You are logged as Room Head\n"
						+ "\n Select one option:"
						+ "\n 1. Book a table"
						+ "\n 2. Advance state of a table"
						+ "\n 0. Exit");
				option = readOption(0, 2);
				switch (option) {
				case 1:
					System.out.println("Select the turn of the booking:"
							+ "\n1. First turn"
							+ "\n2. Second turn"
							+ "\n3. Third turn");
					int turn = readOption(1, 3);
					System.out.println("Selected turn: "+ turn + "º");
					String[] AvailableTables = ManagerEmployee.checkAvailableTables();
					
					if(AvailableTables[0].equals("false")) {
						System.out.println("All our tables are reserved");
					}
					
					else if(AvailableTables[0].equals("true")) {
						System.out.println("Select the table to book:\n"+AvailableTables[1]);
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
				case 2:
					//TODO Read tables with state != 0 and print them.
					//	   then ManagerEmployee.checkAdvanceState(tableID, maxStateTime)
					
					break;
				case 0:
					System.out.println("You have logged out as Room Head correctly");
					break;
				}
				}while (option != 0);
				break;
				
			case 2:
				System.out.println("You have logged as a Table Waiter");
				
				//TODO Next iterations
				break;
			case 0:
				System.out.println("You have exited correctly");
				break;
			}
				
			
			
			
		}while (rol != 0);
	}
	
	public static int readOption(int min, int max){
		int number = sc.nextInt();
			while(number < min || number > max) {
				System.out.println("You must enter a number between "+min+" and "+max);
				number = sc.nextInt();
			}
		return number;
		
	}
}
