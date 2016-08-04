package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SwordfishMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		xWing();
	}

	private void xWing() {
		new SwordfishHorizontally().run(board);
		new SwordfishVertically().run(board);
	}
}
