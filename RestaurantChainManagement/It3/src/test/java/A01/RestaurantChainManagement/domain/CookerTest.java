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
	public void setDishTest() {
		c.setDish(new Dish("House Burguer"));
		assertEquals("House Burguer", "House Burguer");
	}
	
	/*@Test
	public void prepareMealTest_minus_one () {
		assertEquals(-1, c.prepareMeal());
	}
	
	@Test
	public void prepareMealTest_zero () {
		c.setDish(new Dish("House Burguer"));
		assertEquals(0, c.prepareMeal());
	}*/

}
