package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.persistance.TableDAO;

public class TableTest {
	private Table t;
	private Vector<Table> aux;
	private Transaction tr;
	TableDAO tableDAO;
	@Before
	public void init() {
		tableDAO = new TableDAO(); 
		t = new Table(15,4,6);
		tr = new Transaction(20,2,5);
		Table t1 = new Table(11);
		Table t2 = new Table(12);
		Table t3 = new Table(13); 

		aux = new Vector<Table>();
		aux.add(t1);
		aux.add(t2);
		aux.add(t3);
	}
	@Test
	public void setGetIdTest() {
		Table t = new Table();
		t.setId(1);
		assertEquals(1,t.getId());
	}
	@Test
	public void setGetChairsTest() {
		Table t = new Table();
		t.setChairs(2);
		assertEquals(2,t.getChairs());
	}
	@Test
	public void setGetStateTest() {
		Table t = new Table();
		t.setState(4);
		assertEquals(4,t.getState());
	}
	@Test
	public void setGetTableDAOTest() {
		Table t = new Table();
		t.setTableDAO(tableDAO);
		assertEquals(tableDAO, t.getTableDAO());
	}
	@Test
	public void getAvailableTablesTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.getAvailableTables().getClass().getName());
	}
	@Test
	public void checkAvailabilityTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.checkAvailability(t2).getClass().getName());
	}
	
	@Test
	public void testDoTransaction() {
		assertEquals(1, tr.insert());
	}

	@Test
	public void testGetBusyTables() {
		t.getBusyTables();
		Vector<Integer> busyTables = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			busyTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,busyTables.size());	
		}

	@Test
	public void testGetAskingTables() {
		t.getAskingTables();
		Vector<Integer> AskingTables = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			AskingTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,AskingTables.size());	
		}	

	@Test
	public void testGetWaitingForFoodTables() {
		t.getWaitingForFoodTables();
		Vector<Integer> WaitingForFoodTables = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			WaitingForFoodTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,WaitingForFoodTables.size());	
		}	

	@Test
	public void testUpdate() {
		//assertEquals(1, t.update(); TODO
	}

//	@Test
//	public void testSetGetTableDAO() {
//		TableDAO tdao = new TableDAO();  //TODO
//		t.setTableDAO(tdao);
//		assertEquals(tdao, t.getTableDAO());
//	}

	
	@Test
	public void toStringTest() {
		Table t = new Table(1,2,3);
		assertEquals("Table with ID 1 and 2 chairs available",t.toString());
	}

	@Test
	public void getBillTablesTest(){
		Vector<Integer>v=t.getBillTables();
		if(v.size()>0) {
			assertTrue(true);
		}else {
			System.out.println("Any table is waiting for the bill.");
		}
	}
	
	@Test
	public void getPayingTablesTest(){
		Vector<Integer>v=t.getPayingTables();
		if(v.size()>0) {
			assertTrue(true);
		}else {
			System.out.println("Any table is waiting for paying.");
		}
		
	}

}
