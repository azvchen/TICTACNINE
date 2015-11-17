public class Manager {

	private Board mainBoard;
	private Board[] subBoards;

	private int activeBoard;
	private int activePlayer;

	private int winner;

	public Manager() {
		mainBoard = new Board();
		subBoards = new Board[9];
		for (int i = 0; i < 9; i++)
			subBoards[i] = new Board();
		activeBoard = -1;
		activePlayer = 1;
		winner = 0;
	}

	public boolean click(int square) {
		if (square < 0 || square > 8)
			return false; // invalid square
		if (activeBoard == -1) { // if none of the sub boards are active
			if (mainBoard.getPlayerAt(square) == 0) { // if this square of the
														// main board is
														// unoccupied
				activeBoard = square; // make the indicated board active
				return true; // the click did something, return true
			} else {
				return false; // the click did nothing, return false
			}
		} else { // if one of the sub boards is active
			Board board = subBoards[activeBoard]; // call the sub board "board"
			if (board.claimSquare(square, activePlayer)) { // claim the
															// indicated square
															// and check that it
															// was unoccupied
				if (board.checkVictory(activePlayer)) { // if the sub board has
														// been won
					mainBoard.claimSquare(activeBoard, activePlayer); // claim
																		// the
																		// main
																		// board
																		// square
																		// corresponding
																		// to
																		// the
																		// sub
																		// board
					activeBoard = -1; // now none of the sub boards are active,
										// need to choose one
					if (mainBoard.checkVictory(activePlayer)) { // if the entire
																// game has been
																// won
						winner = activePlayer; // make this player the winner of
												// the game
					}
				} else { // if no one has won yet
					toggleActivePlayer(); // switch players, only when a sub
											// board square has been claimed and
											// the sub board has not been won
					if (board.full()) { // the sub board is tied (victory was
										// already checked)
						mainBoard.claimSquare(activeBoard, activePlayer); // the
																			// player
																			// who
																			// did
																			// not
																			// just
																			// play
																			// gets
																			// the
																			// main
																			// board
																			// square
						activeBoard = -1;
					}
				}
				return true; // the click claimed a square, return true
			} else {
				return false; // the click did not do anything, return false
			}
		}
	}

	public int winner() {
		return winner;
	}

	public int activePlayer() {
		return activePlayer;
	}

	public String showPlayerName(int num) {
		String name = null;
		if (num == 1) {
			name = "Android";
		} else {
			name = "Apple";
		}
		return name;
	}

	public int activeBoard() {
		return activeBoard;
	}

	public int[] copyOfActiveBoard() {
		if (activeBoard == -1)
			return mainBoard.getCopyOfBoard();
		else
			return subBoards[activeBoard].getCopyOfBoard();
	}

	private void toggleActivePlayer() {
		activePlayer = activePlayer % 2 + 1; // switches from player 1 to 2 and
												// vice versa
	}

	public int[] getCopyOfActiveBoard() {
		if (activeBoard == -1)
			return mainBoard.getCopyOfBoard();
		else
			return subBoards[activeBoard].getCopyOfBoard();
	}

	public String toString() {
		String str = "Sub Boards:\n";
		for (int i = 0; i < 9; i += 3) {
			str += " --- --- ---   --- --- ---   --- --- ---\n";
			int[][] rowOfBoards = { subBoards[i].getCopyOfBoard(),
					subBoards[i + 1].getCopyOfBoard(),
					subBoards[i + 2].getCopyOfBoard() };
			for (int r = 0; r < 9; r += 3) {
				for (int b = 0; b < 3; b++) {
					for (int c = r; c < r + 3; c++) {
						str += "| " + rowOfBoards[b][c] + " ";
					}
					str += "| ";
				}
				str += "\n --- --- ---   --- --- ---   --- --- ---\n";
			}
		}
		str += "Active Board: " + activeBoard + "\nActive Player: "
				+ activePlayer + "\n";
		str += "Main Board:\n" + mainBoard.toString();
		return str;
	}
}
