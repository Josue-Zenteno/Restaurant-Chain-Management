package A01.RestaurantChainManagement.domain;


public abstract class Waiter {//Iteration2

	/**
	 * 
	 * @param tableID
	 * @param maxStateTime
	 */
	public abstract void advanceState(int tableID, int maxStateTime);

}