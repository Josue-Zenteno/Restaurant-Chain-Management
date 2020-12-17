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
	
		public static int prepareMeal() { //Iteration2 with extras of iteration3
			Cooker c = new Cooker();
			return c.prepareMeal();
		}
		
		public static void getTakeCommandStats() { //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.getTakeCommandStats();
		}
		
		public static void getMealPreparationStats() { //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.getMealPreparationStats();
		}
		
		public static void getDeliveryNoteStats() { //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.getDeliveryNoteStats();
		}

		public static void getPreparationStats() { //Iteration2
			TableWaiter tw = new TableWaiter();
			tw.getPreparationStats();
		}
	}
