import java.util.HashSet;
import java.util.Set;

public class Computer {
	
	/*public static void main(String[] args) {
		int[] board = {2,1,0,0,2,0,0,0,1};
		Set<Integer> freeSquares = getFreeSquares(board);
		
	}*/
	
	public static int play(int[] board) {
		Set<Integer> freeSquares = getFreeSquares(board);
		return goodPlay(board, freeSquares);
	}
	
	private static Set<Integer> getFreeSquares(int[] board) {
		Set<Integer> freeSquares = new HashSet<Integer>();
		for (int i = 0; i < 9; i++)
			if (board[i] == 0)
				freeSquares.add(i);
		return freeSquares;
	}
	
	private static int randomPlay(Set<Integer> freeSquares) {
		return freeSquares.iterator().next();
	}
	
	private static int goodPlay(int[] board, Set<Integer> freeSquares) {
		int play;
		play = win(board, freeSquares, 2);
		if (play != -1)
			return play;
		play = block(board, freeSquares, 2);
		if (play != -1)
			return play;
		play = fork(board, freeSquares, 2);
		if (play != -1)
			return play;
		play = blockFork(board, freeSquares, 2);
		if (play != -1)
			return play;
		return other(board, freeSquares, 2);
		//return randomPlay(freeSquares);
	}
	
	private static int win(int[] board, Set<Integer> freeSquares, int player) {
		for (int a = 0; a < 9; a++) {
			if (board[a] != player)
				continue;
			for (int b = a + 1; b < 9; b++) {
				if (board[b] != player)
					continue;
				int c = complete(a, b);
				if (c != -1 && freeSquares.contains(c)) {
					//System.out.println("win: " + c);
					return c;
				}
			}
		}
		return -1;
	}
	
	private static int block(int[] board, Set<Integer> freeSquares, int player) {
		return win(board, freeSquares, player % 2 + 1);
	}
	
	private static int fork(int[] board, Set<Integer> freeSquares, int player) {
		for (int a : freeSquares) {
			int paths = 0;
			for (int b = 0; b < 9; b++) {
				if (board[b] != player)
					continue;
				int c = complete(a, b);
				if (c != -1 && freeSquares.contains(c)) {
					//System.out.println("path incremented: " + a);
					paths++;
				}
			}
			if (paths > 1) {
				//System.out.println("fork: " + a);
				return a;
			}
		}
		return -1;
	}
	
	private static int blockFork(int[] board, Set<Integer> freeSquares, int player) {
		int oppFork = fork(board, freeSquares, player % 2 + 1);
		if (oppFork != -1)	// if the opponent can fork me, block it
			return oppFork;
		for (int a : freeSquares) {	// if i can make two in a row and not get forked, take it
			int[] nextBoard = replace(board, a, player);
			Set<Integer> nextFrees = getFreeSquares(board);
			int c = win(nextBoard, nextFrees, player);	// if != -1, can get two in a row
			if (c != -1 && fork(nextBoard, nextFrees, player % 2 + 1) != c)	// check if opponent can fork at c
				return a;
		}
		return -1;
	}
	
	private static int other(int[] board, Set<Integer> freeSquares, int player) {
		if (board[4] == 0)	// play in empty center
			return 4;
		for (int a = 0; a < 9; a += 2) {	// play in opposite corner
			if (a == 4)
				continue;
			if (board[a] == player % 2 + 1 && freeSquares.contains(opposite(a)))
				return opposite(a);
		}
		for (int a = 0; a < 9; a += 2) {	// play in empty corner
			if (a == 4)
				continue;
			if (board[a] == 0)
				return a;
		}
		for (int a = 1; a < 9; a += 2) {	// play in empty side
			if (board[a] == 0)
				return a;
		}
		return randomPlay(freeSquares);	// should not be reached
	}
	
	private static int complete(int a, int b) {
		if (a == b)
			return -1;
		if (b == 4) {
			b = a;
			a = 4;
		} else if (a != 4 && location(b) == 1) {
			int t = b;
			b = a;
			a = t;
		}
		
		if (a == 4)
			return opposite(b);
		// if a is side, b is side as well
		else {
			if (location(a) == -1)	// both are side
				return a == opposite(b) ? 4 : -1;
			// a must be corner
			if (location(b) == 1)	// both are corner
				return (a + b) / 2;
			else {	// a is corner, b is side
				switch (a) {
				case 0:
					return (b == 1 || b == 3) ? 2 * b : -1;
				case 2:
					switch (b) {
					case 1:
						return 0;
					case 5:
						return 8;
					default:
						return -1;
					}
				case 6:
					switch (b) {
					case 3:
						return 0;
					case 7:
						return 8;
					default:
						return -1;
					}
				case 8:
					return (b == 5 || b == 7) ? 2 * b - a : -1;
				default:
					return -2;	// should not be reached
				}
			}
		}
	}
	
	private static int location(int a) {
		if (a == 4)	// center
			return 0;
		else if (a % 2 == 0)	// corner
			return 1;
		else	// side
			return -1;
	}
	
	private static int opposite(int a) {
		return 8 - a;
	}
	
	private static int[] replace(int[] board, int a, int player) {
		int[] r = new int[9];
		for (int i = 0; i < 9; i++) {
			if (i != a)
				r[i] = board[i];
			else
				r[i] = player;
		}
		return r;
	}
}
