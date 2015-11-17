
public class Board {

	/**
	 * 	A board is arranged into nine squares with these indices:
	 * 		 --- --- ---
	 * 		| 0 | 1 | 2 |
	 * 		 ---|---|---
	 * 		| 3 | 4 | 5 |
	 * 		 ---|---|---
	 * 		| 6 | 7 | 8 |
	 * 		 --- --- ---
	 * 	Each Board instance has one backing int array called "board".
	 * 	Each player is represented by an int, either 1 or 2.
	 * 	If board[i] == 0, neither player has selected that square yet; 
	 * 	if board[i] == 1 or 2, then player 1 or 2 owns that square; 
	 * 	if board[i] == -1, then neither player can claim that square.
	 */
	
	private int[] board;
	private int winner;
	
	public Board() {
		board = new int[9];
		for (int i = 0; i < 9; i++)
			board[i] = 0;
		winner = 0;
	}
	
	/**
	 * 
	 * @param square
	 * @param player
	 * @return true if the square was successfully claimed
	 */
	public boolean claimSquare(int square, int player) {
		if (board[square] == 0) {
			board[square] = player;
			return true;
		} else
			return false;
	}
	
	public boolean full() {
		for (int p : board)
			if (p == 0)
				return false;
		return true;
	}
	
	/**
	 * 
	 * @param player
	 * @return true if the player won, false otherwise
	 */
	public boolean checkVictory(int player) {
		if (winner != 0) {
			return player == winner;
		}
		if (checkRows(player) || checkColumns(player) || checkDiags(player)) {
			winner = player;
			return true;
		}
		return false;
	}
	
	private boolean checkRows(int player) {
		for (int r = 0; r < 9; r += 3) {
			if (player == board[r] && player == board[r+1] && player == board[r+2])
				return true;
		}
		return false;
	}
	
	private boolean checkColumns(int player) {
		for (int r = 0; r < 3; r++) {
			if (player == board[r] && player == board[r+3] && player == board[r+6])
				return true;
		}
		return false;
	}
	
	private boolean checkDiags(int player) {
		if (player == board[4]) {
			if (player == board[0] && player == board[8] || player == board[2] && player == board[6])
				return true;
		}
		return false;
	}
	
	public int getPlayerAt(int square) {
		return board[square];
	}
	
	public int[] getCopyOfBoard() {
		int[] copy = new int[9];
		for (int i = 0; i < 9; i++)
			copy[i] = board[i];
		return copy;
	}
	
	@Override
	public String toString() {
		String str = " --- --- ---\n";
		for (int i = 0; i < 9; i += 3) {
			for (int j = i; j < i+3; j++) {
				str += "| " + board[j] + " ";
			}
			str += "|\n --- --- ---\n";
		}
		str += "Winner: " + winner;
		return str;
	}
}
