package A01.RestaurantChainManagement.persistance;

import java.util.Vector;
import A01.RestaurantChainManagement.domain.Transaction;

public class TransactionDAO {
	
	/************************Attributes************************/
	private Vector<Transaction> transactionList;
	
	/************************Constructor***********************/
	public TransactionDAO() {
		setTransactionList(new Vector<Transaction>());
	}
	
	/**********************Main functions**********************/
	public void readAll() { //Iteration1
		try {
			Vector<Vector<Object>> v = Broker.getAgente().leer("SELECT * FROM A01dbservice.Transaction;");
			for (int i = 0; i < v.size(); i++) {
				Transaction t = new Transaction(
								(int) v.elementAt(i).elementAt(0),
								(int) v.elementAt(i).elementAt(1),
								(int) v.elementAt(i).elementAt(2));
				transactionList.add(t);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public int insert(Transaction t) {	//Iteration2
		int result = 0;
		try {
			result = Broker.getAgente().cambiar("INSERT INTO `A01dbservice`.`Transaction` (`Time`, `Table`, `State`) VALUES ('"+t.getTime()+"', '"+t.getTable().getId()+"', '"+t.getState()+"');");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;

	}
	
	public Vector<Integer> getTakeCommandStats(){ //Iteration2
		Vector<Integer> takeCommandTimes = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT Time FROM A01dbservice.Transaction WHERE State = 3;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) { 
			takeCommandTimes.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return takeCommandTimes;
	}
	
	public Vector<Integer> getMealPreparationStats(){ //Iteration2
		Vector<Integer> preparationTimes = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT Time FROM A01dbservice.Transaction WHERE State = 4;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			preparationTimes.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return preparationTimes;
	}
	
	public Vector<Integer> getDeliveryNoteStats(){ //Iteration2
		Vector<Integer> deliveryNoteTimes = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();

		try {
			dbVector = Broker.getAgente().leer("SELECT Time FROM A01dbservice.Transaction WHERE State = 6;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

		for(int i=0; i<dbVector.size(); i++) {
			deliveryNoteTimes.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return deliveryNoteTimes;
	}

	public Vector<Integer> getPreparationStats(){ //Iteration2
		Vector<Integer> preparationTimes = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();

		try {
			dbVector = Broker.getAgente().leer("SELECT Time FROM A01dbservice.Transaction WHERE State = 8;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

		for(int i=0; i<dbVector.size(); i++) {
			preparationTimes.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return preparationTimes;
	}
	
	/*******************Auxiliary functions********************/
	public Vector<Transaction> getTransactionList() {
		return transactionList;
	}
	
	public void setTransactionList(Vector<Transaction> transactionList) {
		try {
			this.transactionList = transactionList;
		} catch (Exception e) {
			throw e;
		}
	}
}
