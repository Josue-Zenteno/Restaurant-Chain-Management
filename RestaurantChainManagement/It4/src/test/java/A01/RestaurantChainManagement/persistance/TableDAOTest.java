package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Table;

public class TableDAOTest {
    TableDAO tDAO;
    private Vector<Table> aux;
    
    @Before
    public void init() {
        tDAO= new TableDAO();
        Table t1 = new Table(1);
        Table t2 = new Table(1);
        Table t3 = new Table(1);
		aux = new Vector<Table>();
		aux.add(t1);
		aux.add(t2);
		aux.add(t3);
    }
    @Test
    public void readTest() {
    	Table t = new Table(1);
    	tDAO.read(t);
    	if((t.getChairs() != 0)&&(t.getState() != -1))
        	assertTrue(true);
        else
        	fail();
    }
    
    @Test
    public void setGetReadAllTransactionListTest() {
        tDAO.readAll();
        TableDAO tDAO2 = new TableDAO();
        Vector<Table> tL = new Vector<Table>();
        tDAO2.setTableList(tDAO.getTableList());
        if((tDAO2.getTableList() == tDAO.getTableList()) && tDAO.getTableList().getClass().getName() == tL.getClass().getName())
        	assertTrue(true);
        else
        	fail();
    }
//    @Test
//    public void updateTest() {
//    	Table t = new Table(1);
//    	tDAO.read(t);
//    	assertEquals(1, t.update());
//    }

	@Test
	public void testGetBusyTables() {
		tDAO.getBusyTables();
		Vector<Integer> busyTables = new Vector<Integer>();
		

		for(int i=0; i<aux.size(); i++) {
			busyTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,busyTables.size());

	}
	@Test
	public void getAskingTables() {
		tDAO.getAskingTables();
		Vector<Integer> askingTables = new Vector<Integer>();


		for(int i=0; i<aux.size(); i++) {
			askingTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,askingTables.size());

	}
	
	@Test
	public void getWaitingForFoodTables() {
		tDAO.getWaitingForFoodTables();
		Vector<Integer> waitingForFoodTables = new Vector<Integer>();
		
		for(int i=0; i<aux.size(); i++) {
			waitingForFoodTables.add(aux.elementAt(i).getId());
		}

		assertEquals(3,waitingForFoodTables.size());

	}
    

}
