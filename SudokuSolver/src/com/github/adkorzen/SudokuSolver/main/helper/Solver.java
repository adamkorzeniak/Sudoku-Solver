package com.github.adkorzen.SudokuSolver.main.helper;

import com.github.adkorzen.SudokuSolver.main.Board;

public class Solver {

	public static void printSolution(Board b) {
		int[][] results = b.getResult();
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
}
