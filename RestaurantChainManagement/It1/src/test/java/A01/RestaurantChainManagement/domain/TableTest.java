package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.persistance.TableDAO;

class TableTest {
	TableDAO tableDAO;
	@Before
	void init() {
		tableDAO = new TableDAO();
	}
	
	@Test
	void setGetTransactionTest1() {
		Table t = new Table();
		Transaction[] tr = new Transaction[9];
		tr[1]=new Transaction(10,5);
		t.setTransactionList(tr);
		assertArrayEquals(tr, t.getTransactionList());
	}

	@Test
	void getTransactionTest2() {
		int lengthTransactionArray=9;
		Table t = new Table();
		assertEquals(lengthTransactionArray, t.getTransactionList().length);
	}


	@Test
	void setGetIdTest() {
		Table t = new Table();
		t.setId(1);
		assertEquals(1,t.getId());
	}
	@Test
	void setGetChairsTest() {
		Table t = new Table();
		t.setChairs(2);
		assertEquals(2,t.getChairs());
	}
	@Test
	void setGetStateTest() {
		Table t = new Table();
		t.setState(4);
		assertEquals(4,t.getState());
	}
	@Test
	void setGetTableDAOTest() {
		Table t = new Table();
		t.setTableDAO(tableDAO);
		assertEquals(tableDAO, t.getTableDAO());
	}
	@Test
	void readAllTest() {
		Table t = new Table();
		t.readAll();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(),tableDAO.getTableList().getClass().getName());
		
	}
	@Test
	void getAvailableTablesTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.getAvailableTables().getClass().getName());
	}
	@Test
	void checkAvailabilityTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.checkAvailability(t2).getClass().getName());
	}
	
	
}
