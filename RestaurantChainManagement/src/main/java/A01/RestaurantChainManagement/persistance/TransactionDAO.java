package A01.RestaurantChainManagement.persistance;

import java.util.Vector;
import A01.RestaurantChainManagement.domain.Transaction;

public class TransactionDAO {
	private Vector<Transaction> transactionList;
	
	public TransactionDAO() {
		transactionList = new Vector<Transaction>();
	}

	public int insert(Transaction t) {	
		int result = 0;
		try {
			result = Broker.getAgente().cambiar("INSERT INTO `A01dbservice`.`Transaction` (`Time`, `Table`) VALUES ('"+t.getTime()+"', '"+t.getTable().getId()+"');");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;

	}
	
	public void readAll() {
		try {
			Vector<Vector<Object>> v = Broker.getAgente().leer("SELECT * FROM A01dbservice.Transaction;");
			for (int i = 0; i < v.size(); i++) {
				int time = (int) v.elementAt(i).elementAt(0);
				int tableid = (int) v.elementAt(i).elementAt(1);
				Transaction t = new Transaction(tableid,time);
				transactionList.add(t);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Vector<Transaction> getTransactionList() {
		return transactionList;
	}
}
