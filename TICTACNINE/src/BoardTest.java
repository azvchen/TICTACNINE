import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	private Board board = new Board();
	
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testInit() {
		System.out.println("Test Init");
		System.out.println(board.toString());
		assertTrue(true);
	}
	
	@Test
	public void testClaim() {
		System.out.println("Test Claim");
		assertTrue(board.claimSquare(2, 1));
		System.out.println(board);
		assertFalse(board.claimSquare(2, 2));
		System.out.println(board);
	}

	@Test
	public void testVictory() {
		System.out.println("Test Victory");
		board.claimSquare(2, 1);
		board.claimSquare(4, 2);
		board.claimSquare(1, 1);
		board.claimSquare(3, 2);
		System.out.println(board);
		board.claimSquare(0, 1);
		System.out.println(board);
		assertFalse(board.checkVictory(2));
		assertTrue(board.checkVictory(1));
		System.out.println(board);
		assertEquals(board.getPlayerAt(7), 0);
		assertTrue(board.claimSquare(7, 2));
		System.out.println(board);
		assertFalse(board.checkVictory(2));
	}
}
