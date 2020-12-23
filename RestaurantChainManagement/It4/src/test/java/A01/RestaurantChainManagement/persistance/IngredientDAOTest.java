package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class IngredientDAOTest {

	IngredientDAO iDAO;

	@Before
	public void init() {
		iDAO= new IngredientDAO();
	}
	@Test
	public void testReadAllAvailables() { //Testing catch block -> Bug detected
		iDAO.readAllAvailables();
		assertEquals(new Vector<String>().getClass().getName(),iDAO.getIngredientsList().getClass().getName());
	}

	@Test
	public void testSetGetIngredientsList() {
		Vector<String> v = new Vector<String>();
		v.add("Bread");
		v.add("Burguer");
		iDAO.setIngredientsList(v);
		iDAO.getIngredientsList();
	}

}
