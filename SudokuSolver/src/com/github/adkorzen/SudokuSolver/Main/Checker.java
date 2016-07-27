package com.github.adkorzen.SudokuSolver.Main;

import com.github.adkorzen.SudokuSolver.Main.Methods.CandidateLinesMethod;
import com.github.adkorzen.SudokuSolver.Main.Methods.MultipleLinesMethod;
import com.github.adkorzen.SudokuSolver.Main.Methods.NakedPairs;
import com.github.adkorzen.SudokuSolver.Main.Methods.SingleCandidateMethod;
import com.github.adkorzen.SudokuSolver.Main.Methods.SinglePositionMethod;

public class Checker {
	private static Board board;
	private static boolean changeHappened = false;


	// Not yet finished
	public static void solveBoard(Board b) {
		board = b;
		do {
			changeHappened = false;
			SingleCandidateMethod.run(board);
			SinglePositionMethod.run(board);
			CandidateLinesMethod.run(board);
			MultipleLinesMethod.run(board);
			NakedPairs.run(board);
		} while (changeHappened);
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

	/// only for testing purposes, delete after application completed
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

	public static void setChangeHappend() {
		changeHappened = true;
	}
	
	public static int startXSquare(int square) {
		return (square - 1) % 3 * 3 + 1;
	}
	
	public static int startYSquare(int square) {
		return (square - 1) / 3 * 3 + 1;
	}
}
