package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DishTest {

Dish d;
	
	@Before
	public void test() {
		d = new Dish();
	}
	
	@Test
	public void getDishesTest_desired_lenght () {
		int numberOfDishesInDB = 4;
		assertEquals(numberOfDishesInDB, d.getDishes().length);
	}
	
	@Test
	public void getDishesTest_full_of_dishes_0 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, d.getDishes()[0].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_1 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, d.getDishes()[1].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_2 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, d.getDishes()[2].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_3 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, d.getDishes()[3].getClass().getName());
	}

}
