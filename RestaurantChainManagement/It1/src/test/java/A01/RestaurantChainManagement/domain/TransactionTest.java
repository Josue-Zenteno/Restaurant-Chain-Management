package A01.RestaurantChainManagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import A01.RestaurantChainManagement.persistance.TransactionDAO;


class TransactionTest {
	

	Transaction tr;
	@BeforeEach
	void init() {
		tr = new Transaction();
	}
	
	@Test
	void setgetTimeTest() {
		Transaction tr = new Transaction();
		tr.setTime(5);
		assertEquals(5,tr.getTime());
	}
	
	@Test
	void setgetTableTest() {
		Table t = new Table();
		tr.setTable(t);
		assertEquals(t,tr.getTable());
	}
	@Test
	void setgetTransactionDAO() {
		TransactionDAO trDAO=new TransactionDAO();
		tr.setTransactionDAO(trDAO);
		assertEquals(trDAO,tr.getTransactionDAO());
	}
}
