package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomHeadTest {
	
	@Test
	public void advanceStateTest1() {
		Table t = new Table(1);
		t.read();
		int s = t.getState();
		assertTrue("An id that is going to return false",!RoomHead.advanceState(1, 20));
		t.setState(s);
		t.update();
		
	}
	@Test
	public void advanceStateTest2() {
		Table t = new Table(7);
		t.read();
		int s = t.getState();
		assertTrue("An id that is going to return true", RoomHead.advanceState(7, 20));
		t.setState(s);
		t.update();
		
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

}
