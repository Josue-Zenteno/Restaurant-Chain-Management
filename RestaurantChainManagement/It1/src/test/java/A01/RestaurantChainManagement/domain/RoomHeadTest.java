package A01.RestaurantChainManagement.domain;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

class RoomHeadTest {

	@Test
	void advanceStateTest1() {
		assertTrue("An id that is going to return false",!RoomHead.advanceState(1, 20));

	}
	@Test
	void advanceStateTest2() {
		assertTrue("An id that is going to return true", RoomHead.advanceState(7, 20));
	}
	
	@Test
	void availableTablesTest() {
		String[] r = RoomHead.availableTables();
		try {
			Integer.parseInt(r[2]);
			Boolean.parseBoolean(r[0]);
			assertTrue(true);
		}catch(InputMismatchException e) {
			
		}
	}

}
