package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Transaction;

class TransactionDAOTest {

    TransactionDAO trDAO;
    @Before
    void init() {
        trDAO = new TransactionDAO();
    }

    @Test
    void getTransactionListTest() {
        trDAO.readAll();
        Vector<Transaction> trL=new Vector<Transaction>();
        assertEquals(trL.getClass().getName(), trDAO.getTransactionList().getClass().getName());
    }
}

