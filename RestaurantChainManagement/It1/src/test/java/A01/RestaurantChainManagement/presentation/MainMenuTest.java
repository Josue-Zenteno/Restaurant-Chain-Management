package A01.RestaurantChainManagement.presentation;

import static org.junit.Assert.*;

import org.junit.Test;

class MainMenuTest {

	@Test
	void readOptionTest() {
		int o = MainMenu.readOption(0, 5);
		boolean f;
		if(o>5 || o<0)  f = false; else f = true;
		assertTrue(f);
	}

}
