package A01.RestaurantChainManagement.domain;

public class ManagerEmployee {
	
		/**********************Main functions**********************/
		public static String[] checkAvailableTables() { //ITeration1
			String[] avaiableTables=RoomHead.availableTables();
			return avaiableTables;
		}
		public static boolean checkAdvanceState(int TableID,int maxStateTime) { //ITeration1
			return RoomHead.advanceState(TableID,maxStateTime);
		}
		
		public static void attendTable() { //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.attendTable();
		}
		
		public static void makeOrder(){ //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.makeOrder();
		}
	
		public static void prepareMeal() { //Iteration2
			Cooker c = new Cooker();
			c.prepareMeal();
		}
		
		public static void getTakeCommandStats() {
			TableWaiter tw = new TableWaiter();
			tw.getTakeCommandStats();
		}
		
		public static void getMealPreparationStats() {
			TableWaiter tw = new TableWaiter();
			tw.getMealPreparationStats();
		}
	}
