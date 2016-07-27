package com.github.adkorzen.SudokuSolver.Main.Methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.Main.Board;
import com.github.adkorzen.SudokuSolver.Main.Checker;
import com.github.adkorzen.SudokuSolver.Main.Field;

public class CandidateLinesMethod {
	private static Board board;
	
	private static boolean[] candidateLinesTrySquare = new boolean[9];

	static {
		for (int i = 0; i < candidateLinesTrySquare.length; i++) {
			candidateLinesTrySquare[i] = true;
		}
	}

	public static void run(Board b) {
		board = b;
		candidateLinesMethod();
	}
	
	private static void candidateLinesMethod() {
		while (candidateLinesTry()) {
			for (int a = 1; a < 10; a++) {
				if (candidateLinesTrySquare[a - 1]) {
					candidateLinesMethodCheckSquare(a);
				}
			}
		}
	}

	private static void candidateLinesMethodCheckSquare(int square) {

		candidateLinesTrySquare[square - 1] = false;
		int startX = Checker.startXSquare(square);
		int startY = Checker.startYSquare(square);

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

			if (isOnOneLine(arrayToCheck)) {
				Field toChange = null;
				int y = arrayToCheck.get(0).getY();

				for (int x = 1; x < 10; x++) {
					toChange = board.getField(x, y);
					if (!arrayToCheck.contains(toChange) && toChange.getValue() == 0 && toChange.isPossible(possible)) {
						toChange.setImpossibleValue(possible);
						candidateLinesTrySquare[square - 1] = true;
					}
				}
			}
			if (isOnOneColumn(arrayToCheck)) {
				Field toChange = null;
				int x = arrayToCheck.get(0).getX();

				for (int y = 1; y < 10; y++) {
					toChange = board.getField(x, y);
					if (!arrayToCheck.contains(toChange) && toChange.getValue() == 0 && toChange.isPossible(possible)) {
						toChange.setImpossibleValue(possible);
						candidateLinesTrySquare[square - 1] = true;
					}
				}
			}
		}
	}

	private static boolean isOnOneLine(List<Field> arrayToCheck) {
		int y = arrayToCheck.get(0).getY();
		for (int i = 1; i < arrayToCheck.size(); i++) {
			if (arrayToCheck.get(i).getY() != y) {
				return false;
			}
		}
		return true;
	}

	private static boolean isOnOneColumn(List<Field> arrayToCheck) {
		int x = arrayToCheck.get(0).getX();
		for (int i = 1; i < arrayToCheck.size(); i++) {
			if (arrayToCheck.get(i).getX() != x) {
				return false;
			}
		}
		return true;
	}

	private static boolean candidateLinesTry() {
		for (int i = 0; i < 9; i++) {
			if (candidateLinesTrySquare[i]) {
				return true;
			}
		}
		return false;
	}

}
