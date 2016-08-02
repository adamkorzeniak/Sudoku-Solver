package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Board;

public class HiddenPairsMethod {

	public void run(Board b) {
		hiddenPairsMethod(b);
	}

	private void hiddenPairsMethod(Board b) {
		new HiddenPairsHorizontally().run(b);
		new HiddenPairsVertically().run(b);
		new HiddenPairsSquare().run(b);
	}
}
