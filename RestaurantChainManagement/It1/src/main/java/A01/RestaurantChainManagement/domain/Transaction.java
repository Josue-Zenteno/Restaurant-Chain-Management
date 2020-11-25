package A01.RestaurantChainManagement.domain;

import A01.RestaurantChainManagement.persistance.TransactionDAO;

public class Transaction {
	private int time;
	private TransactionDAO transactionDAO;
	private Table table;

	public Transaction() {
		setTransactionDAO(new TransactionDAO());
	}
	
	public Transaction(int time,int tableId) {
		setTransactionDAO(new TransactionDAO());
		setTime(time);
		table = new Table(tableId);
		table.read();
		setTable(table);
	}

	public void setTime(int time) {
		try {
			this.time = time;
			
		} catch (Exception e) {
			throw e;
		}
	}

	public void setTable(Table tableid) {
		try {
			this.table = tableid;

		} catch (Exception e) {
			throw e;
		}
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		try {
			this.transactionDAO = transactionDAO;

		} catch (Exception e) {
			throw e;
		}
	}

	public int getTime() {
		return time;
	}

	public Table getTable() {
		return table;
	}
	
	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}
	
	public String toString() {
		return "Transaction in table "+this.table.getId()+" with time "+this.getTime();
	}
	
	public int insert() {
		return transactionDAO.insert(this);
	}

}

