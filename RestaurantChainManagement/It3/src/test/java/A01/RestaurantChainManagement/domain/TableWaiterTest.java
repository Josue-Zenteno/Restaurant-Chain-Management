package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TableWaiterTest {

	private TableWaiter tw;
	private Vector<Integer> tables;
	private Vector<String> ing;
	private Dish d;
	private Vector<String> menu;
	
	
	@Before
	public void init() {

		tw = new TableWaiter();
		
		Table t1 = new Table(10);
        Table t2 = new Table(11);
        Table t3 = new Table(12);
        
		tables = new Vector<Integer>();
		tables.add(t1.getId());
		tables.add(t2.getId());
		tables.add(t3.getId());
		
		ing = new Vector<String>();
		ing.add("Absenta");
		ing.add("AUAUAUAUAUAU");
		ing.add("Bacon");
		ing.add("BBQ Sauce");
		ing.add("Burguer");
		ing.add("Burguer Bread");
		ing.add("Cheese");
		ing.add("Eggs");
		ing.add("Fried Tomato");
		ing.add("Hard work");
		ing.add("Lettuce");
		ing.add("Macaroni");
		ing.add("Mince");
		ing.add("Oil");
		ing.add("Onion");
		ing.add("Parsley");
		ing.add("Spartan Blood");
		ing.add("Sulfuric Acid");
		
		d = new Dish("DRUNK ESPARTANO");
		d.read();
		menu = new Vector<String>();
		menu.add("DRUNK ESPARTANO");
		menu.add("House Burguer");
		menu.add("Macarroni con tomati");
		menu.add("Parsley Omelette");


	}

	@Test
	public void testAttendTable() {
		tw.attendTable();
		assertNotNull(tw);
	}
	
	@Ignore
	@Test
	public void testMakeOrder() {
		tw.makeOrder();		
		assertNotNull(tw);
	}

	@Test
	public void testTryToMakeAnOrder() {
		assertTrue(tw.tryToMakeAnOrder(ing, d));
	}

	@Test
	public void testGetBusyTables() {
		assertNotNull(tw.getBusyTables());	
		}

	@Test
	public void testGetAskingTables() {
		assertNotNull(tw.getAskingTables());
		}

	@Test
	public void testGetWaitingForFoodTables() {
		assertNotNull(tw.getWaitingForFoodTables());
	}
	@Test
	public void testgetTakeCommandStats() {
		tw.getTakeCommandStats();
		assertNotNull(tw);
	}
	@Test
	public void testgetMealPreparationStats() {
		tw.getMealPreparationStats();
		assertNotNull(tw);
	}
	@Test
	public void testgetDeliveryNoteStats() {
		tw.getDeliveryNoteStats();
		assertNotNull(tw);
	}
	@Test
	public void testgetPreparationStats() {
		tw.getPreparationStats();
		assertNotNull(tw);
	}
	

	@Test
	public void testGetAvailableIng() {
		assertEquals(ing, tw.getAvailableIng());
		
	}

	@Ignore
	@Test
	public void testAskForTable() { //inputMismatch
		System.out.println("Insert String");
		assertEquals(-1, tw.askForTable(tables, "test"));
	}
	
	@Ignore
	@Test
	public void testAskForTable1() { // number = -10
		System.out.println("Insert -10");
		assertEquals("Insert -10",-10, tw.askForTable(tables, "test"));
	}
	
	@Ignore
	@Test
	public void testAskForTable2() { // number = 10
		System.out.println("Insert 10");
		assertEquals("Insert 10",10, tw.askForTable(tables, "test"));
	}
	
	@Ignore
	@Test
	public void testAskForDish() { //Entering a String causes a infinite loop
		System.out.println("Select 0");
		assertEquals(d.getName(), tw.askForDish(menu).getName());	
		}
	
	@Test
	public void testgetMenu() {
		assertEquals(menu, tw.getMenu());
	}

}
