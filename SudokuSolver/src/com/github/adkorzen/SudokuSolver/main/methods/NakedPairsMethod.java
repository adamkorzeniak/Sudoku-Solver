package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class NakedPairsMethod {

	public void run(Board b) {
		nakedPairsMethod(b);
	}

	private void nakedPairsMethod(Board b) {
		new NakedPairsHorizontally().run(b);
		new NakedPairsVertically().run(b);
		new NakedPairsSquare().run(b);
	}
}
