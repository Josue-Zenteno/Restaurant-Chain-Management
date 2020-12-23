package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.persistance.TableDAO;
import A01.RestaurantChainManagement.persistance.TransactionDAO;

public class TransactionTest {
	TransactionDAO transactionDAO;
	@Before
	public void init() {
		transactionDAO = new TransactionDAO();
	}
	@Test
	public void setGetTimeTest() {
		Transaction tr = new Transaction();
		tr.setTime(1);
		assertEquals(1,tr.getTime());
	}
	@Test
	public void setGetTableTest() {
		Transaction tr = new Transaction();
		Table t = new Table(1,2,3);
		tr.setTable(t);
		assertEquals(t,tr.getTable());
	}
	@Test
	public void setGetTransactionDAOTest() {
		Transaction tr = new Transaction();
		tr.setTransactionDAO(transactionDAO);
		assertEquals(transactionDAO, tr.getTransactionDAO());
	}
	@Test
	public void toStringTest() {
		Transaction tr = new Transaction(10,1);
		assertEquals("Transaction in table 1 with time 10",tr.toString());
	}

}
