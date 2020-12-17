package A01.RestaurantChainManagement.domain;

import java.util.Vector;
import A01.RestaurantChainManagement.persistance.TableDAO;

public class Table {
	
	/************************Attributes************************/
	private int id;
	private int chairs;
	private int state;
	private TableDAO tableDAO;
	
	/************************Constructor***********************/
	public Table() {
		setTableDAO(new TableDAO());
	}
	
	public Table(int id) {
		setTableDAO(new TableDAO());
		setId(id);
	}

	public Table(int id,int chairs ,int state) {
		setTableDAO(new TableDAO());
		setId(id);
		setChairs(chairs);
		setState(state);
	}
	
	/**********************Main functions**********************/
	public Vector<Table> getAvailableTables() { //Iteration1		 
		this.readAll();
		Vector<Table> tableList =  getTableDAO().getTableList();
		
		Vector<Table> availableTables = checkAvailability(tableList);
		
		return availableTables;
	}
	
	public Vector<Table> checkAvailability(Vector<Table> v) { //Iteration1
		Vector<Table> availableTables = new Vector<Table>();
		for (Table table : v) {
			if (table.getState() == 0) {
				availableTables.add(table);
			}
		}
		return availableTables;
	}
	
	public void doTransaction(int time) { //Iteration2
		Transaction tr = new Transaction(time, getId(), getState()-1);
		tr.insert();
	}
	
	public Vector<Integer> getBusyTables(){ //Iteration2
		return getTableDAO().getBusyTables();
	}
	
	public Vector<Integer> getAskingTables(){ //Iteration2
		return getTableDAO().getAskingTables();
	}
	
	public Vector<Integer> getWaitingForFoodTables(){ //Iteration2
		return getTableDAO().getWaitingForFoodTables();	
	}
	
	/*******************Auxiliary functions********************/
	public void read() {
		tableDAO.read(this);
	}
	
	public void readAll() {
		tableDAO.readAll();
	}
	
	public void update() { //Iteration2
		getTableDAO().update(this);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		try {
			this.id = id;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public int getChairs() {
		return this.chairs;
	}

	public void setChairs(int chairs) {
		try {
			this.chairs = chairs;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		try {
			this.state = state;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public TableDAO getTableDAO() {
		return this.tableDAO;
	}
	
	public void setTableDAO(TableDAO tableDAO) {
		try {
			this.tableDAO = tableDAO;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String toString() {
		return "Table with ID "+this.id+" and "+this.chairs+" chairs available";
	}
}