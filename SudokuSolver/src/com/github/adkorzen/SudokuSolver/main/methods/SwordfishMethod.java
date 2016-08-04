package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SwordfishMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		xWing();
	}

	// consists of Swingfish and X-Wing Methods
	private void xWing() {
		new SwordfishHorizontally().run(board);
		new SwordfishVertically().run(board);
	}
}
