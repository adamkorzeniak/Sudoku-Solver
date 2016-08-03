package com.github.adkorzen.SudokuSolver.main.helper;

import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.methods.CandidateLinesMethod;
import com.github.adkorzen.SudokuSolver.main.methods.HiddenPairsMethod;
import com.github.adkorzen.SudokuSolver.main.methods.MultipleLinesMethod;
import com.github.adkorzen.SudokuSolver.main.methods.NakedPairsMethod;
import com.github.adkorzen.SudokuSolver.main.methods.SingleCandidateMethod;
import com.github.adkorzen.SudokuSolver.main.methods.SinglePositionMethod;
import com.github.adkorzen.SudokuSolver.main.methods.XWingMethod;

public class Solver {
	private static Board board;
	private static boolean changeHappened = false;


	// Not yet finished
	public static void solveBoard(Board b) {
		board = b;
		new SingleCandidateMethod().run(board);
		do {
			changeHappened = false;
			new SinglePositionMethod().run(board);
			new CandidateLinesMethod().run(board);
			new MultipleLinesMethod().run(board);
			new NakedPairsMethod().run(board);
			new HiddenPairsMethod().run(board);
			new XWingMethod().run(board);
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
						System.out.println(i + "," + j);
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
}
