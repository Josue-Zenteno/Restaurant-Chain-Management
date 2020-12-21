package A01.RestaurantChainManagement.persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import A01.RestaurantChainManagement.domain.Table;

class TableDAOTest {
    TableDAO tDAO;
    
    @BeforeEach
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
