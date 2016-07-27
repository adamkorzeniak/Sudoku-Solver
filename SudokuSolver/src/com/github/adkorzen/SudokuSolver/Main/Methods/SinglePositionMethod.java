package com.github.adkorzen.SudokuSolver.Main.Methods;

import java.util.ArrayList;
import java.util.List;

import com.github.adkorzen.SudokuSolver.Main.Board;
import com.github.adkorzen.SudokuSolver.Main.Checker;
import com.github.adkorzen.SudokuSolver.Main.Field;

public class SinglePositionMethod {
	private static Board board;
	private static boolean singlePositionChangeHappened;

	public static void run(Board b) {
		board = b;
		singlePosition();
	}
	
	private static void singlePosition() {

		do {
			singlePositionChangeHappened = false;
			checkLine();
			checkColumn();
			checkSquare();
		} while (singlePositionChangeHappened);

	}

	private static void checkLine() {
		List<Field> possiblePosition = null;
		for (int j = 1; j < 10; j++) {
			for (int value = 1; value < 10; value++) {
				possiblePosition = new ArrayList<Field>();
				for (int i = 1; i < 10; i++) {
					Field toCheck = board.getField(i, j);
					if (toCheck.isPossible(value)) {
						possiblePosition.add(toCheck);
					}
				}
				if (possiblePosition.size() == 1) {
					possiblePosition.get(0).setValue(value);
					singlePositionChangeHappened = true;
				}
			}
		}
	}

	private static void checkColumn() {
		List<Field> possiblePosition = null;
		for (int i = 1; i < 10; i++) {
			for (int value = 1; value < 10; value++) {
				possiblePosition = new ArrayList<Field>();
				for (int j = 1; j < 10; j++) {
					Field toCheck = board.getField(i, j);
					if (toCheck.isPossible(value)) {
						possiblePosition.add(toCheck);
					}
				}
				if (possiblePosition.size() == 1) {
					possiblePosition.get(0).setValue(value);
					singlePositionChangeHappened = true;
				}
			}
		}
	}

	private static void checkSquare() {
		List<Field> possiblePosition = null;
		for (int square = 1; square < 10; square++) {
			int startX = Checker.startXSquare(square);
			int startY = Checker.startYSquare(square);

			for (int value = 1; value < 10; value++) {
				possiblePosition = new ArrayList<Field>();
				for (int i = startX; i < startX + 3; i++) {
					for (int j = startY; j < startY + 3; j++) {

						Field toCheck = board.getField(i, j);
						if (toCheck.isPossible(value)) {
							possiblePosition.add(toCheck);
						}

					}
				}
				if (possiblePosition.size() == 1) {
					possiblePosition.get(0).setValue(value);
					singlePositionChangeHappened = true;
				}

			}
		}
	}

}
