package A01.RestaurantChainManagement.domain;

import java.util.Vector;

import A01.RestaurantChainManagement.persistance.TransactionDAO;

public class Transaction {
	
	/************************Attributes************************/
	private int time;
	private int state;
	private Table table;
	private TransactionDAO transactionDAO;
	
	/************************Constructor***********************/
	public Transaction() {
		setTransactionDAO(new TransactionDAO());
	}
	
	public Transaction(int time, int idTable, int state) {
		setTransactionDAO(new TransactionDAO());
		setTime(time);
		setTable(new Table(idTable));
		setState(state);
	}
	
	/**********************Main functions**********************/
	public int insert() {
		return transactionDAO.insert(this);
	}
	
	public double getTakeCommandStats() { //Iteration2
		Vector<Integer> takeCommandTimes = getTransactionDAO().getTakeCommandStats();
		if(takeCommandTimes.size() != 0) { 
			int totalTime = 0;
			for(int time : takeCommandTimes) {
				totalTime += time;
			}
			return (totalTime/takeCommandTimes.size());
		}else {
			return 0.0;
		}
	}
	
	public double getMealPreparationStats() { //Iteration2
		Vector<Integer> mealPreparationTimes = getTransactionDAO().getMealPreparationStats();
		if(mealPreparationTimes.size() != 0) {
			int totalTime = 0;
			for(int time : mealPreparationTimes) {
				totalTime += time;
			}
			return (totalTime/mealPreparationTimes.size());
		}else{
			return 0.0;
		}
	}
	
	public double getDeliveryNoteStats() { //Iteration2
		Vector<Integer> deliveryNoteTimes = getTransactionDAO().getDeliveryNoteStats();
		if(deliveryNoteTimes.size() != 0) {
			int totalTime = 0;
			for(int time : deliveryNoteTimes) {
				totalTime += time;
			}
			return (totalTime/deliveryNoteTimes.size());
		}else {
			return 0.0;
		}
	}

	public double getPreparationStats() { //Iteration2
		Vector<Integer> preparationTimes = getTransactionDAO().getPreparationStats();
		if(preparationTimes.size() != 0) {
			int totalTime = 0;
			for(int time : preparationTimes) {
				totalTime += time;
			}
			return (totalTime/preparationTimes.size());
		}else{
			return 0.0;
		}
	}
	
	/*******************Auxiliary functions********************/
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		try {
			this.time = time;
			
		} catch (Exception e) {
			throw e;
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table transactionTable) {
		try {
			transactionTable.read();
			this.table = transactionTable;

		} catch (Exception e) {
			throw e;
		}
	}
	
	public TransactionDAO getTransactionDAO() {
		return this.transactionDAO;
	}
	
	public void setTransactionDAO(TransactionDAO transactionDAO) {
		try {
			this.transactionDAO = transactionDAO;

		} catch (Exception e) {
			throw e;
		}
	}

	public String toString() {
		return "Transaction in table "+this.table.getId()+" with time "+this.getTime();
	}
}