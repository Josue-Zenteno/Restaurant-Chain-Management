package A01.RestaurantChainManagement.persistance;

import java.util.Vector;

import A01.RestaurantChainManagement.domain.Table;

public class TableDAO {
	private Vector<Table> TableList;


	public TableDAO() {
		setTableList(new Vector<Table>());
	}
	
	public void read(Table t) {
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
	
	public void readAll() {
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
	
	public Vector<Table> getTableList() {
		return TableList;
	}
	
	public void setTableList(Vector<Table> tableList) {
		TableList = tableList;
	}
	
	public int update(Table t) {
		int actualizado=0;
		try {
			actualizado= Broker.getAgente().cambiar("UPDATE `A01dbservice`.`Table` SET `State` ='" + t.getState() + "' WHERE (`TableID` = '"+ t.getId()+ "');");
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return actualizado;
	}
}
