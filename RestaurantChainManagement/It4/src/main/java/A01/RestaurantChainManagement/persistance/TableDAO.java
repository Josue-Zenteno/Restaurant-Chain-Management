package A01.RestaurantChainManagement.persistance;

import java.util.Vector;

import A01.RestaurantChainManagement.domain.Table;

public class TableDAO {
	
	/************************Attributes************************/
	private Vector<Table> TableList;
	
	/************************Constructor***********************/
	public TableDAO() {
		setTableList(new Vector<Table>());
	}
	
	/**********************Main functions**********************/
	public void read(Table t) { //Iteration1
		try {
			Vector<Vector<Object>> v = Broker.getAgente().leer("SELECT * FROM A01dbservice.Table WHERE TableID = "+t.getId()+";");

				int chairs = (int) v.elementAt(0).elementAt(1);
				t.setChairs(chairs);
				int state = (int) v.elementAt(0).elementAt(2);
				t.setState(state);
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void readAll() { //Iteration1
		try {
			Vector<Vector<Object>> v = Broker.getAgente().leer("SELECT * FROM A01dbservice.Table;");
			for (int i = 0; i < v.size(); i++) {
				int id = (int) v.elementAt(i).elementAt(0);
				int chairs = (int) v.elementAt(i).elementAt(1);
				int state = (int) v.elementAt(i).elementAt(2);

				Table t = new Table(id,chairs,state);
				TableList.add(t);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public int update(Table t) { //Iteration1
		int actualizado=0;
		try {
			actualizado= Broker.getAgente().cambiar("UPDATE `A01dbservice`.`Table` SET `State` ='" + t.getState() + "' WHERE (`TableID` = '"+ t.getId()+ "');");
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return actualizado;
	}
	
	public Vector<Integer> getBusyTables(){ //Iteration2
		Vector<Integer> busyTables = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT TableID FROM A01dbservice.Table WHERE State = 2;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			busyTables.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return busyTables;
	}
	
	public Vector<Integer> getAskingTables(){ //Iteration2
		Vector<Integer> askingTables = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT TableID FROM A01dbservice.Table WHERE State = 3;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			askingTables.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return askingTables;
	}

	public Vector<Integer> getWaitingForFoodTables(){ //Iteration2
		Vector<Integer> waitingForFoodTables = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT TableID FROM A01dbservice.Table WHERE State = 4;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			waitingForFoodTables.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return waitingForFoodTables;
	}
	
	public Vector<Integer> getWaitingForBillTables(){ //Iteration4
		Vector<Integer> waitingForBillTables = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT TableID FROM A01dbservice.Table WHERE State = 6;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			waitingForBillTables.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return waitingForBillTables;
	}
	
	public Vector<Integer> getPayingTables(){ //Iteration4
		Vector<Integer> payingTables = new Vector<Integer>();
		Vector<Vector<Object>> dbVector = new Vector<Vector<Object>>();
		
		try {			
			dbVector = Broker.getAgente().leer("SELECT TableID FROM A01dbservice.Table WHERE State = 7;");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		for(int i=0; i<dbVector.size(); i++) {
			payingTables.add((Integer) dbVector.elementAt(i).elementAt(0));
		}
		return payingTables;
	}
	
	/*******************Auxiliary functions********************/
	public Vector<Table> getTableList() {
		return TableList;
	}
	
	public void setTableList(Vector<Table> tableList) {
		TableList = tableList;
	}
}