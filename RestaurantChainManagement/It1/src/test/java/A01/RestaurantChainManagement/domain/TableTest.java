package A01.RestaurantChainManagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import A01.RestaurantChainManagement.persistance.TableDAO;

class TableTest {
	TableDAO tableDAO;
	@BeforeEach
	void init() {
		tableDAO = new TableDAO();
	}
	
	@Test
	void setGetTransactionTest1() {
		Table t = new Table();
		Transaction[] tr = new Transaction[9];
		tr[1].setTime(10);
		tr[2].setTime(20);
		t.setTransactionList(tr);
		assertAll(
				() -> assertThrows(NullPointerException.class, ()-> t.setTransactionList(null)),
				() -> assertEquals(tr, t.getTransactionList())
				);	
	}

	@Test
	void getTransactionTest2() {
		int lengthTransactionArray=9;
		Table t = new Table();
		assertEquals(lengthTransactionArray, t.getTransactionList().length, "The length returned should be 9");
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
		Table[] t2 = new Table[2];
		assertEquals(t2.getClass().getName(),tableDAO.getTableList().getClass().getName());
		
	}
	@Test
	void getAvailableTablesTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.getAvailableTables());
	}
	@Test
	void checkAvailabilityTest() {
		Table t = new Table();
		Vector<Table> t2 = new Vector<Table>();
		assertEquals(t2.getClass().getName(), t.checkAvailability(t2));
	}
	
	
}
