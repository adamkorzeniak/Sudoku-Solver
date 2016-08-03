package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class XWingMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		xWing();
	}

	private void xWing() {
		new XWingHorizontally().run(board);
		new XWingVertically().run(board);
	}
}
