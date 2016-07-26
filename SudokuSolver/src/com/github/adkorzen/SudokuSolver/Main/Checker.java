package com.github.adkorzen.SudokuSolver.Main;

import java.util.ArrayList;
import java.util.List;

public class Checker {
	private static Board board;
	private static Field field;

	private static boolean[] candidateLinesTrySquare = new boolean[9];
	private static boolean singlePositionChangeHappened;

	static {
		for (int i = 0; i < candidateLinesTrySquare.length; i++) {
			candidateLinesTrySquare[i] = true;
		}
	}

	// Not yet finished
	public static void solveBoard(Board b) {
		board = b;
		singleCandidateMethod();
		singlePosition();
		candidateLinesMethod();
	}

	private static void singleCandidateMethod() {
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
		Checker.crossOutFromLine(field);
		Checker.crossOutFromColumn(field);
		Checker.crossOutFromSquare(field);
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
			int startX = (square - 1) % 3 * 3 + 1;
			int startY = (square - 1) / 3 * 3 + 1;

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
		int startX = (square - 1) % 3 * 3 + 1;
		int startY = (square - 1) / 3 * 3 + 1;

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

	/// only for testing purposes, delete after aplication complited
	public static boolean isSolutionNotIncorrect(Board board) {
		int[][] results = board.getResult();
		boolean[] numberTaken = new boolean[9];

		// checking lines
		for (int i = 0; i < 9; i++) {
			for (int a = 0; a < 9; a++) {
				numberTaken[a] = false;
			}
			for (int j = 0; j < 9; j++) {
				if (results[i][j] > 0) {
					if (numberTaken[results[i][j] - 1] == false) {
						numberTaken[results[i][j] - 1] = true;
					} else {
						return false;
					}
				}
			}
		}
		// checking columns
		for (int j = 0; j < 9; j++) {
			for (int a = 0; a < 9; a++) {
				numberTaken[a] = false;
			}
			for (int i = 0; i < 9; i++) {
				if (results[i][j] > 0) {
					if (numberTaken[results[i][j] - 1] == false) {
						numberTaken[results[i][j] - 1] = true;
					} else {
						return false;
					}
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
					if (results[i][j] > 0) {
						if (numberTaken[results[i][j] - 1] == false) {
							numberTaken[results[i][j] - 1] = true;
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
