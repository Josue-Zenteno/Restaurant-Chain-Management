package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import A01.RestaurantChainManagement.domain.Dish;

public class DishDAOTest {

	private DishDAO dDAO;
	private Dish d;
	private String[] ingredients = {"Burguer Bread","Burguer","Cheese","BBQ Sauce","Lettuce"};

	@Before
    public void init() {
        dDAO = new DishDAO();
		d = new Dish("House Burguer");

    }
	
	@Test
	public void testRead() {
		dDAO.read(d);

		int numberOfIngredientsPerDish = 5;
		assertNotNull(d.getIngredients()[0]);
		assertNotNull(d.getIngredients()[1]);
		assertNotNull(d.getIngredients()[2]);
		assertNotNull(d.getIngredients()[3]);
		assertNotNull(d.getIngredients()[4]);

		assertEquals(numberOfIngredientsPerDish,d.getIngredients().length);
	}	

	@Test 
	public void testRead2() {
		dDAO.read(d);
		assertArrayEquals(ingredients, d.getIngredients());
	}
	
	@Test 
	public void testGetMenu() {
		int totaldishes = 4;  //The DB has 4 dishes ALWAYS
		assertEquals(totaldishes,dDAO.getMenu().size());
	}
	
	@Test
	public void getDishesTest_desired_lenght () {
		int numberOfDishesInDB = 4;
		assertEquals(numberOfDishesInDB, dDAO.getDishes().length);
	}
	
	@Test
	public void getDishesTest_full_of_dishes_0 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, dDAO.getDishes()[0].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_1 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, dDAO.getDishes()[1].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_2 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, dDAO.getDishes()[2].getClass().getName());
	}
	
	@Test
	public void getDishesTest_full_of_dishes_3 () {
		String espectedType = d.getClass().getName();
		assertEquals(espectedType, dDAO.getDishes()[3].getClass().getName());
	}

}
