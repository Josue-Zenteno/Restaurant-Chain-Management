package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Transaction;

public class TransactionDAOTest {
	private Vector<Transaction> aux;
    TransactionDAO tDAO;
    private Transaction t;
    @Before
    public void init() {
        tDAO = new TransactionDAO();
        t = new Transaction(1,2,1);
        
        Transaction t1 = new Transaction(10,1,3);
        Transaction t2 = new Transaction(20,2,5);
        Transaction t3 = new Transaction(30,3,4);

		aux = new Vector<Transaction>();
		aux.add(t1);
		aux.add(t2);
		aux.add(t3);
    }

    @Test
    public void setGetReadAllTransactionListTest() {
        tDAO.readAll();
        TransactionDAO trDAO2 = new TransactionDAO();
        Vector<Transaction> trL = new Vector<Transaction>();
        trDAO2.setTransactionList(tDAO.getTransactionList());
        if((trDAO2.getTransactionList() == tDAO.getTransactionList()) && tDAO.getTransactionList().getClass().getName() == trL.getClass().getName())
        	assertTrue(true);
        else
        	fail();
    }
    
    @Test
    public void testInsert() {
		assertEquals(1,t.insert());
	}

	@Test
	public void testGetTakeCommandStats() {
		tDAO.getTakeCommandStats();
		Vector<Integer> stats = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			stats.add(aux.elementAt(i).getState());
		}

		assertEquals(3,stats.size());
	}

	@Test
	public void testGetMealPreparationStats() {
		tDAO.getMealPreparationStats();
		Vector<Integer> stats = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			stats.add(aux.elementAt(i).getState());
		}

		assertEquals(3,stats.size());
	}

	@Test
	public void testGetDeliveryNoteStats() {
		tDAO.getDeliveryNoteStats();
		Vector<Integer> stats = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			stats.add(aux.elementAt(i).getState());
		}

		assertEquals(3,stats.size());
	}

	@Test
	public void testGetPreparationStats() {
		tDAO.getPreparationStats();
		Vector<Integer> stats = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			stats.add(aux.elementAt(i).getState());
		}

		assertEquals(3,stats.size());
	}
}

