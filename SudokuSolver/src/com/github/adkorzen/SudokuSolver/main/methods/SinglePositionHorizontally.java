package com.github.adkorzen.SudokuSolver.main.methods;

import com.github.adkorzen.SudokuSolver.main.Field;

public class SinglePositionHorizontally extends AbstractSinglePosition {

	@Override
	public Field acquireField(int i, int j) {
		return board.getField(i, j);
	}
}
