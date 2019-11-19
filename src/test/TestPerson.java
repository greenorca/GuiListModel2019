/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Person;

/**
 * @author sven
 *
 */
public class TestPerson {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCtor() {
		String name="Hallo";
		String adresse = "Adresse";
		String photo="/dev/null";
		Person p = new Person(name, adresse, photo);
		assertEquals("getName NOK", name, p.getName());
		assertEquals("getAdress NOK", adresse, p.getAddresse());
		assertEquals("getPhoto NOK", photo, p.getPhoto());
	}

}
