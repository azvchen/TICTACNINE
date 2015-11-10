import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {

	private Manager manager = new Manager();
	
	/*
	@Test
	public void testInit() {
		System.out.println(manager);
		assertTrue(true);
	}
	*/

	@Test
	public void testClick() {
		assertTrue(manager.click(8));
		System.out.println(manager);
		assertTrue(manager.click(8));
		System.out.println(manager);
		assertTrue(manager.click(4));
		System.out.println(manager);
		assertTrue(manager.click(5));
		System.out.println(manager);
		assertFalse(manager.click(5));
		System.out.println(manager);
		assertTrue(manager.click(7));
		assertTrue(manager.click(6));
		assertFalse(manager.click(7));
		assertTrue(manager.click(1));
		System.out.println(manager);
		assertTrue(manager.click(4));
		System.out.println(manager);
	}
}
