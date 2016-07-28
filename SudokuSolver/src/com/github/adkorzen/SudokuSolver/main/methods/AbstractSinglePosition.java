package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public abstract class AbstractSinglePosition {

	protected Board board;

	public void run(Board b) {
		board = b;
		check();
	}

	protected void check() {
		List<Field> possiblePosition = null;
		for (int j = 1; j < 10; j++) {
			for (int value = 1; value < 10; value++) {
				possiblePosition = new ArrayList<Field>();
				for (int i = 1; i < 10; i++) {
					addToPossiblePosition(possiblePosition, value, i, j);
				}
				isOnlySolution(possiblePosition, value);
			}
		}
	}

	protected void addToPossiblePosition(List<Field> possiblePosition, int value, int i, int j) {
		Field toCheck = acquireField(i, j);
		if (toCheck.isPossible(value)) {
			possiblePosition.add(toCheck);
		}
	}

	protected void isOnlySolution(List<Field> possiblePosition, int value) {
		if (possiblePosition.size() == 1) {
			possiblePosition.get(0).setValue(value);
		}
	}

	protected abstract Field acquireField(int i, int j);
}
