package com.github.adkorzen.SudokuSolver.main.methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;
import com.github.adkorzen.SudokuSolver.main.helper.Helper;

public class CandidateLinesMethod {
	private Board board;

	public void run(Board b) {
		board = b;
		candidateLinesMethod();
	}

	private void candidateLinesMethod() {
		for (int a = 1; a < 10; a++) {
			candidateLinesMethodCheckSquare(a);
		}
	}

	private void candidateLinesMethodCheckSquare(int square) {

		int startX = Helper.startXSquare(square);
		int startY = Helper.startYSquare(square);

		for (int possible = 1; possible < 10; possible++) {
			List<Field> arrayToCheck = new ArrayList<Field>();
			for (int j = startY; j < startY + 3; j++) {
				for (int i = startX; i < startX + 3; i++) {
					Field toCheck = board.getField(i, j);
					if (toCheck.getValue() == 0 && toCheck.isPossible(possible)) {
						arrayToCheck.add(toCheck);
					}
				}
			}
			if (arrayToCheck.isEmpty()) {
				continue;
			}
			new CandidateLinesHorizontally().run(board, arrayToCheck, possible);
			new CandidateLinesVertically().run(board, arrayToCheck, possible);
		}
	}
}
