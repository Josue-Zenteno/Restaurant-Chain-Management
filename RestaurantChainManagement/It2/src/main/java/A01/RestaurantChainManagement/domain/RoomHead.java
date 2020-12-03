package A01.RestaurantChainManagement.domain;

import java.util.Random;
import java.util.Vector;

public class RoomHead {
	
	/**********************Main functions**********************/
	public static boolean advanceState(int TableID,int maxStateTime) { //Iteration2
		Random r = new Random();
		Table t = new Table(TableID);
		t.read();
		if (t.getState() != 0 && t.getState() != 1) {  				// state 0 = free, state 1 = reserved, state 8 = in preparation
			return false;											// Which are the states handled by the Room Head
		} else {
			int time = r.nextInt(maxStateTime) + 1;  				// As we need to store the time value, we simulate it for every state.
			t.setState(t.getState()+2);  							//RoomHead turns the state of a table from Free(0) to Busy(2)
			t.update();
			t.doTransaction(time);
			return true;
		}
	}
	public static String[] availableTables() { //Iteration1			// returning = [ true/false , toString of each available Table , Number of tables]
		String[] returning = new String[3];
		Table tAux = new Table();
		Vector<Table> v = tAux.getAvailableTables();
		returning[0] = "false";
		returning[1] = "";
		returning[2] = String.valueOf(v.size());
		
		if(v.size() == 0){
			returning[0] = "false";
		}
		else {
			returning[0] = "true";
			for (int i = 0; i < v.size(); i++) {
				returning[1] += "\n"+(i+1)+". " + v.elementAt(i).toString();
			}
		}
		return returning;
	}
	
}
