package com.github.adkorzen.SudokuSolver.main.methods;


import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

public class SingleCandidateMethod {
	private static Board board;
	private Field field;
	
	public void run(Board b) {
		board = b;
		singleCandidateMethod();
	}
	
	private void singleCandidateMethod() {
		for (int y = 1; y < 10; y++) {
			for (int x = 1; x < 10; x++) {
				field = board.getField(x, y);
				int value = field.getValue();
				if (value > 0 && value < 10) {
					crossOutFromLineColumnSquare(field);
				}
			}
		}
	}
	
	public static void crossOutFromLineColumnSquare(Field field) {
		crossOutFromLine(field);
		crossOutFromColumn(field);
		crossOutFromSquare(field);
	}
	
	private static void crossOutFromLine(Field field) {
		int y = field.getY();
		int value = field.getValue();

		for (int i = 1; i < 10; i++) {
			Field checked = board.getField(i, y);
			if (checked.getValue() == 0) {
				checked.setImpossibleValue(value);
			}
		}
	}

	private static void crossOutFromColumn(Field field) {
		int x = field.getX();
		int value = field.getValue();

		for (int i = 1; i < 10; i++) {
			Field checked = board.getField(x, i);
			if (checked.getValue() == 0) {
				checked.setImpossibleValue(value);
			}
		}
	}

	private static void crossOutFromSquare(Field field) {
		int x = field.getX();
		int y = field.getY();
		int value = field.getValue();

		int startX = (x + 2) / 3 * 3 - 2;
		int startY = (y + 2) / 3 * 3 - 2;

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				Field checked = board.getField(startX + i, startY + j);
				if (checked.getValue() == 0) {
					checked.setImpossibleValue(value);
				}
			}
		}
	}
}
