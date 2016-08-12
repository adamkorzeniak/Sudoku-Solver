package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Field;

public class CandidateLinesHorizontally extends AbstractCandidateLines {

	@Override
	protected Field acquireField(List<Field> arrayToCheck, int i) {
		return board.getField(i, arrayToCheck.get(0).getY());
	}

	@Override
	protected boolean fieldOnOtherLine(List<Field> arrayToCheck, int i) {
		if (arrayToCheck.get(i).getY() != arrayToCheck.get(0).getY()) {
			return true;
		}
		return false;
	}
}
