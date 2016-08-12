package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Field;

public class HiddenPairsHorizontally extends AbstractHiddenPairs {

	@Override
	protected Field acquireField(int line, int i) {
		return board.getField(i, line);
	}
}
