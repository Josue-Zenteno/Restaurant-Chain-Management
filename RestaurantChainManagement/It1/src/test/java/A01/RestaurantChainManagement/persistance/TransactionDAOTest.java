package A01.RestaurantChainManagement.persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import A01.RestaurantChainManagement.domain.Transaction;

class TransactionDAOTest {

    TransactionDAO trDAO;
    @BeforeEach
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
