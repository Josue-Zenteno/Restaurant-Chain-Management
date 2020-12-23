package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.persistance.TableDAO;

public class TableTest {
	TableDAO tableDAO;
	@Before
	public void init() {
		tableDAO = new TableDAO();
	}
	
	@Test
	public void setGetTransactionTest1() {
		Table t = new Table();
		Transaction[] tr = new Transaction[9];
		tr[1]=new Transaction(10,5);
		t.setTransactionList(tr);
		assertArrayEquals(tr, t.getTransactionList());
	}
	@Test
	public void getTransactionTest2() {
		int lengthTransactionArray=9;
		Table t = new Table();
		assertEquals(lengthTransactionArray, t.getTransactionList().length);
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
	public void toStringTest() {
		Table t = new Table(1);
		t.read();
		String[] s = t.toString().split(" ");
		try {
			Integer.parseInt(s[3]);
			Integer.parseInt(s[5]);
			assertTrue("This checks that the returned atributes of the toString are both integers",true);
		}catch(InputMismatchException e) {
			fail();
		}
		
	}
	
	
	
}
