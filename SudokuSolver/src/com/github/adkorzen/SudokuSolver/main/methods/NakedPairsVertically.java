package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Field;

public class NakedPairsVertically extends AbstractNakedPairs {

	protected Field acquireField(int line, int i) {
		return board.getField(line, i);
	}
}
