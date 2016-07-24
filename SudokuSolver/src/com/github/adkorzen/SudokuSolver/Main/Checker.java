package com.github.adkorzen.SudokuSolver.Main;

public class Checker {
	private static Board board;
	private static Field field;

	// Not yet finished
	public static void solveBoard(Board b) {
		board = b;
		initialUpdate();
	}

	private static void initialUpdate() {
		for (int y = 1; y < 10; y++) {
			for (int x = 1; x < 10; x++) {
				field = board.getField(x, y);
				int value = field.getValue();
				if (value > 0 && value < 10) {
					checkLineColumnSquare(field);
				}
			}
		}
	}

	public static void checkLineColumnSquare(Field field) {
		Checker.checkLine(field);
		Checker.checkColumn(field);
		Checker.checkSquare(field);
	}

	private static void checkLine(Field field) {
		int y = field.getY();
		int value = field.getValue();

		for (int i = 1; i < 10; i++) {
			Field checked = board.getField(i, y);
			if (checked.getValue() == 0) {
				checked.setImpossibleValue(value);
			}
		}
	}

	private static void checkColumn(Field field) {
		int x = field.getX();
		int value = field.getValue();

		for (int i = 1; i < 10; i++) {
			Field checked = board.getField(x, i);
			if (checked.getValue() == 0) {
				checked.setImpossibleValue(value);
			}
		}
	}

	private static void checkSquare(Field field) {
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

	public static void printSolution() {
		int[][] results = board.getResult();
		for (int i = 0; i < 9; i++) {
			int[] res = results[i];
			for (int j = 0; j < 9; j++) {
				System.out.print(res[j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean isSolutionCorrect(Board board) {
		int[][] results = board.getResult();
		boolean[] numberTaken = new boolean[9];

		// checking lines
		for (int i = 0; i < 9; i++) {
			for (int a = 0; a < 9; a++) {
				numberTaken[a] = false;
			}
			for (int j = 0; j < 9; j++) {
				if (numberTaken[results[i][j] - 1] == false) {
					numberTaken[results[i][j] - 1] = true;
				} else {
					return false;
				}
			}
		}
		// checking columns
		for (int j = 0; j < 9; j++) {
			for (int a = 0; a < 9; a++) {
				numberTaken[a] = false;
			}
			for (int i = 0; i < 9; i++) {
				if (numberTaken[results[i][j] - 1] == false) {
					numberTaken[results[i][j] - 1] = true;
				} else {
					return false;
				}
			}
		}
		// checking squares
		for (int square = 0; square < 9; square++) {
			for (int a = 0; a < 9; a++) {
				numberTaken[a] = false;
			}
			
			int startX = square / 3 * 3;
			int startY = square % 3 * 3;

			for (int j = startY; j < startY + 3; j++) {
				for (int i = startX; i < startX + 3; i++) {
					if (numberTaken[results[i][j] - 1] == false) {
						numberTaken[results[i][j] - 1] = true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
