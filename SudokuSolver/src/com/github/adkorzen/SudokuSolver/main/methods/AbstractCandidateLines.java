package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractCandidateLines {
	protected Board board;

	public void run(Board b, List<Field> arrayToCheck, int possible) {
		board = b;
		crossOut(arrayToCheck, possible);
	}

	protected void crossOut(List<Field> arrayToCheck, int possible) {
		if (isOnOneLine(arrayToCheck)) {
			Field toChange = null;
			for (int i = 1; i < 10; i++) {
				toChange = acquireField(arrayToCheck, i);
				if (!arrayToCheck.contains(toChange) && toChange.getValue() == 0 && toChange.isPossible(possible)) {
					toChange.setImpossibleValue(possible);
				}
			}
		}
	}

	protected boolean isOnOneLine(List<Field> arrayToCheck) {
		for (int i = 1; i < arrayToCheck.size(); i++) {
			if (fieldOnOtherLine(arrayToCheck, i)) {
				return false;
			}
		}
		return true;
	}

	protected abstract Field acquireField(List<Field> arrayToCheck, int i);

	protected abstract boolean fieldOnOtherLine(List<Field> arrayToCheck, int i);

}
