package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomHeadTest {
	private Table t;
	private Table t1;
	private int s;
	private int s1;
	
	@Before
	public void init() {
		t = new Table(7, 4, 1);
		t.read();
		s=t.getState();
		t1 = new Table(1, 4, 1);
		t1.read();
		s1=t1.getState();
	}
	
	@Test
	public void availableTablesTest() {
		String[] r = RoomHead.availableTables();
		try {
			Integer.parseInt(r[2]);
			Boolean.parseBoolean(r[0]);
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testAdvanceState() { 
		assertTrue(RoomHead.advanceState(7, 20));
		t.setState(s);
		t.update();
	}
	@Test
	public void testAdvanceState2() { 
		assertFalse(RoomHead.advanceState(1, 20));
		t1.setState(s1);
		t1.update();
	}

}
