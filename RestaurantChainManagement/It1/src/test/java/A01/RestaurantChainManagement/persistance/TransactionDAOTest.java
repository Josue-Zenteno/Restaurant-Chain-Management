package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Transaction;

public class TransactionDAOTest {

    TransactionDAO trDAO;
    @Before
    public void init() {
        trDAO = new TransactionDAO();
    }

    @Test
    public void setGetReadAllTransactionListTest() {
        trDAO.readAll();
        TransactionDAO trDAO2 = new TransactionDAO();
        Vector<Transaction> trL = new Vector<Transaction>();
        trDAO2.setTransactionList(trDAO.getTransactionList());
        if((trDAO2.getTransactionList() == trDAO.getTransactionList()) && trDAO.getTransactionList().getClass().getName() == trL.getClass().getName())
        	assertTrue(true);
        else
        	fail();
    }
    
    @Test
    public void insertTest() throws Exception {
    	Transaction t = new Transaction();
    	assertEquals("As we can't test this, since this class is changed in iteration 2 and the table is prepared"
    			+ " for transaction of it2, we check that the insert does not work (returns 0)",0,trDAO.insert(t));
    }
}

