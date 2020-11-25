package A01.RestaurantChainManagement.domain;


public class ManagerEmployee {
		public static String[] checkAvailableTables() {
			String[] avaiableTables=RoomHead.availableTables();
			return avaiableTables;
		}
		public static boolean checkAdvanceState(int TableID,int maxStateTime) {
			
			return RoomHead.advanceState(TableID,maxStateTime);
		}
		
	
	}
