package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.persistance.TransactionDAO;

public class TransactionTest {
	private Transaction t;
	private Vector<Integer> commandtimes;
	private Vector<Integer> mealPreparationtimes;
	private Vector<Integer> deliverytimes;
	private Vector<Integer> preparationtimes;
	TransactionDAO transactionDAO;
	@Before
	public void init() {
		transactionDAO = new TransactionDAO();
		t = new Transaction(20,6,5);
		commandtimes = t.getTransactionDAO().getTakeCommandStats();
		mealPreparationtimes = t.getTransactionDAO().getMealPreparationStats(); 
		deliverytimes = t.getTransactionDAO().getDeliveryNoteStats();
		preparationtimes = t.getTransactionDAO().getPreparationStats(); 
		
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
	public void testGetTakeCommandStats() {

		double totalTime = 0;
		double returned = t.getTakeCommandStats();
		for(double time : commandtimes) {
			totalTime += time;
		}
		assertEquals(totalTime/commandtimes.size(), returned,0);
	}

	@Test
	public void testGetTakeCommandStats2() {
		assumeTrue(commandtimes.isEmpty());
			double returned = t.getTakeCommandStats();
			assertEquals(0.0, returned,0);
	}

	@Test
	public void testGetMealPreparationStats() {

		double totalTime = 0;
		double returned = t.getMealPreparationStats();
		for(double time : mealPreparationtimes) {
			totalTime += time;
		}
		assertEquals(totalTime/mealPreparationtimes.size(), returned,0);
	}
	
	@Test
	public void testGetMealPreparationStats2() {
		assumeTrue(mealPreparationtimes.isEmpty());
			double returned = t.getMealPreparationStats();
			assertEquals(0.0, returned,0);

	}

	@Test
	public void testGetDeliveryNoteStats() {
		double totalTime = 0;
		double returned = t.getDeliveryNoteStats();
		for(double time : deliverytimes) {
			totalTime += time;
		}
		assertEquals(totalTime/deliverytimes.size(), returned,0);
	}
	
	@Test
	public void testGetDeliveryNoteStats2() {
		assumeTrue(deliverytimes.isEmpty());
			double returned = t.getDeliveryNoteStats();
			assertEquals(0.0, returned,0);
	}

	@Test
	public void testGetPreparationStats() {

		double totalTime = 0;
		double returned = t.getPreparationStats();
		for(double time : preparationtimes) {
			totalTime += time;
		}
		assertEquals(totalTime/preparationtimes.size(), returned,0);
	}
	
	@Test
	public void testGetPreparationStats2() {
		assumeTrue(preparationtimes.isEmpty());
			double returned = t.getPreparationStats();
			assertEquals(0.0, returned,0);
	}

	@Test
	public void testGetState() {
		assertEquals(5, t.getState());
	}

	@Test
	public void testSetState() {
		t.setState(8);
		assertEquals(8, t.getState());
	}
	
	@Test
	public void toStringTest() {
		Transaction tr = new Transaction(10,1,5);
		assertEquals("Transaction in table 1 with time 10",tr.toString());
	}
	
	@Test
	public void insertTest(){
		Transaction t = new Transaction(30,1,0);
		assertEquals(1,t.insert());
	}
}
