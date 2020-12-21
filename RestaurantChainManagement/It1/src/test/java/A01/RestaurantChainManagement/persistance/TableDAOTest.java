package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Table;

class TableDAOTest {
    TableDAO tDAO;
    
    @Before
    void init() {
        tDAO= new TableDAO();
    }

    @Test
    void getTableListTest(){
        tDAO.readAll();
        Vector<Table> tl= new Vector<Table>();
        assertEquals(tl.getClass().getName(),tDAO.getTableList().getClass().getName(), "");
    }

}
