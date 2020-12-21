package A01.RestaurantChainManagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

class RoomHeadTest {

	@Test
	void advanceStateTest() {
		assertAll(
				() ->assertTrue(!RoomHead.advanceState(1, 20),"An id that is going to return false"),
				() ->assertTrue(RoomHead.advanceState(7, 20),"An id that is going to return true")
				);
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
