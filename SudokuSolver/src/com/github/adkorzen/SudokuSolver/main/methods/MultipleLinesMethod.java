package com.github.adkorzen.SudokuSolver.main.methods;


import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class MultipleLinesMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		multipleLinesMethod();
	}
	// consists both: Double Pairs and Multiple Lines Methods
	private void multipleLinesMethod() {
		List<List<Field>> lists = null;
		List<Field> arrayToCheck = null;
		for (int possible = 1; possible < 10; possible++) {
			lists = new ArrayList<List<Field>>();
			for (int square = 1; square < 10; square++) {
				arrayToCheck = new ArrayList<Field>();
				int startX = Helper.startXSquare(square);
				int startY = Helper.startYSquare(square);
				for (int j = startY; j < startY + 3; j++) {
					for (int i = startX; i < startX + 3; i++) {
						Field toCheck = board.getField(i, j);
						if (toCheck.getValue() == 0 && toCheck.isPossible(possible)) {
							arrayToCheck.add(toCheck);
						}
					}
				}
				lists.add(arrayToCheck);
			}
			checkMultipleLines(lists, possible);
		}
	}

	private void checkMultipleLines(List<List<Field>> list, int possible) {
		new MultipleLinesHorizontally().run(board, list, possible);
		new MultipleLinesVertically().run(board, list, possible);
	}
}
