package A01.RestaurantChainManagement.domain;

import java.util.Vector;

import A01.RestaurantChainManagement.domain.Transaction;
import A01.RestaurantChainManagement.persistance.TableDAO;

public class Table {
	private int id;
	private int chairs;
	private int state;
	private Transaction[] TransactionList;
	private TableDAO tableDAO;	
	
	public Table() {
		setTableDAO(new TableDAO());
		setTransactionList(new Transaction[9]);
	}
	
	public Table(int id) {
		setTableDAO(new TableDAO());
		setTransactionList(new Transaction[9]);
		setId(id);
	}

	public Table(int id, int chairs, int state) {
		setChairs(chairs);
		setState(state);
		setId(id);
		setTransactionList(new Transaction[9]);
		setTableDAO(new TableDAO());
	}

	public Transaction[] getTransactionList() {
		return TransactionList;
	}

	public void setTransactionList(Transaction[] transactionList) {
		try {
			TransactionList = transactionList;

		} catch (Exception e) {
			if (transactionList == null){
				throw e;
			}
		}
	}

	public int doTransaction(int time) {
		Transaction t = new Transaction(time,this.id);
		TransactionList[this.state] = t;
		
		return t.insert();
	}

	public TableDAO getTableDAO() {
		return tableDAO;
	}
	
	public void setId(int id) {
		try {
			this.id = id;
		} catch (Exception e) {
			throw e;
		}
	}

	public void setChairs(int chairs) {
		try {
			this.chairs = chairs;
		} catch (Exception e) {
			throw e;
		}
	}

	public void setState(int state) {
		try {
			this.state = state;
		} catch (Exception e) {
			throw e;
		}
	}

	public void setTableDAO(TableDAO tableDAO) {
		try {
			this.tableDAO = tableDAO;
		} catch (Exception e) {
			throw e;
		}
	}

	public int getChairs() {
		return this.chairs;
	}

	public int getState() {
		return this.state;
	}

	public int getId() {
		return this.id;
	}
	
	public void read() {
		tableDAO.read(this);
	}
	
	public void readAll() {
		tableDAO.readAll();
	}
	
	public int update() {
		return tableDAO.update(this);
	}
	
	public String toString() {
		
		//TODO concatenate the state string to the return value to be more user-friendly
//		
//		String stateString = "";
//		switch (this.getState()) {
//		case 0:
//			stateString="Free";
//			break;
//		case 1:
//			stateString="Reserved";
//			break;
//		case 2:
//			stateString="Busy";
//			break;
//		case 3:
//			stateString="Asking";
//			break;
//		case 4:
//			stateString="Waiting for food";
//			break;
//		case 5:
//			stateString="Served";
//			break;
//		case 6:
//			stateString="Waiting for the bill";
//			break;
//		case 7:
//			stateString="Paying";
//			break;
//		case 8:
//			stateString="In preparation";
//			break;
//		}
		return "Table with ID "+this.id+" and "+this.chairs+" chairs available";
	}
	
	public Vector<Table> getAvailableTables() {				 
		this.readAll();
		Vector<Table> tableList =  getTableDAO().getTableList();
		
		Vector<Table> availableTables = checkAvailability(tableList);
		
		return availableTables;
	}
	
	
	public Vector<Table> checkAvailability(Vector<Table> v) {
		Vector<Table> availableTables = new Vector<Table>();
		for (Table table : v) {
			if (table.getState() == 0) {
				availableTables.add(table);
			}
		}
		return availableTables;
	}
}
