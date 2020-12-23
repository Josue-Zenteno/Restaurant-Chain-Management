package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ManagerEmployeeTest {

    private TableWaiter tw;
    private Cooker c;
    @Before
    public void init() {

        tw = new TableWaiter();
        c= new Cooker();
    }

    @Test
    public void testGetTakeCommandStats() {
        ManagerEmployee.getTakeCommandStats();
        assertNotNull(tw);
    }

    @Test
    public void testGetMealPreparationStats() {
        ManagerEmployee.getMealPreparationStats();
        assertNotNull(tw);
    }

    @Test
    public void testGetDeliveryNoteStats() {
        ManagerEmployee.getDeliveryNoteStats();
        assertNotNull(tw);
    }

    @Test
    public void testGetPreparationStats() {
        ManagerEmployee.getPreparationStats();
        assertNotNull(tw);
    }

    @Test
    public void testPrepareMeal() {
        ManagerEmployee.prepareMeal();
        assertNotNull(c);
    }
    /*@Test
    public void testMakeOrder() {
        ManagerEmployee.makeOrder();
        assertNotNull(tw);
    }
    @Test
    public void testAttendTable() {
        ManagerEmployee.attendTable();
        assertNotNull(tw);
    }
    */
    
}