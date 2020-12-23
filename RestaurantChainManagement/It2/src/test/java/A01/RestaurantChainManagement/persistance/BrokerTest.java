package A01.RestaurantChainManagement.persistance;

import static org.junit.Assert.*;

import org.junit.Before;
import java.util.Vector;
import org.junit.Test;

public class BrokerTest {
	Broker broker;
	
	@Before
	public void setUp() throws Exception {
		broker = new Broker();
	}
	
	@Test
	public void getAgenteTest() throws Exception {
		assertEquals(broker.getClass().getName(), Broker.getAgente().getClass().getName());
	}
	
	@Test
	public void leerTest() throws Exception {
		assertNotEquals(0, broker.leer("SELECT * FROM A01dbservice.Table WHERE TableID=1;").size());
	}
	@Test
	public void cambiarTest() throws Exception{
		Vector<Vector<Object>> vector = broker.leer("SELECT * FROM A01dbservice.Ingredients WHERE Name='AUAUAUAUAUAU';");
		assertEquals(1,broker.cambiar("UPDATE A01dbservice.Ingredients SET Stock="+vector.elementAt(0).elementAt(1)+" WHERE Name='AUAUAUAUAUAU';"));
		
	}

}
