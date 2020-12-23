package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CookerTest {

    private Cooker c;
    @Before
    public void init() {
        c = new Cooker(); 
    }

    @Test
    public void testPrepareMeal() {
        c.prepareMeal();
        assertNotNull(c);
    }

}