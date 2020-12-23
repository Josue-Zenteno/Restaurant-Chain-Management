package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomHeadTest {
	private Table t;
	private Table t1;
	private int s;
	@Before
	public void init() {
		t = new Table(1, 4, 1);
		t.read();
		s=t.getState();
		t1 = new Table(3, 4, 1);
		t1.read();
		s=t1.getState();
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
	public void testAdvanceState() { //Table with id 1 should be state = 0 after calling this test
		assertTrue(RoomHead.advanceState(1, 20));
		t.setState(s);
		t.update();
	}
	@Test
	public void testAdvanceState2() { ////Table with id 2 should be (state != 0 || 1) before calling this test
		assertFalse(RoomHead.advanceState(2, 20));
		t1.setState(s);
		t1.update();
	}

}
