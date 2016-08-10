package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverXWing {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_XWingBoard_CorrectResult() {
		Board board = new Board("res/methods/X-Wing.txt");
		board.solve();

		int[][] expecteds = { { 9, 6, 2, 4, 5, 1, 7, 3, 8 }, { 1, 4, 7, 3, 9, 8, 2, 6, 5 },
				{ 5, 8, 3, 2, 7, 6, 4, 9, 1 }, { 8, 1, 6, 7, 2, 4, 3, 5, 9 }, { 2, 3, 9, 1, 6, 5, 8, 4, 7 },
				{ 4, 7, 5, 9, 8, 3, 6, 1, 2 }, { 6, 2, 1, 5, 3, 7, 9, 8, 4 }, { 7, 5, 8, 6, 4, 9, 1, 2, 3 },
				{ 3, 9, 4, 8, 1, 2, 5, 7, 6 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_XWing2Board_CorrectResult() {
		Board board = new Board("res/methods/X-Wing2.txt");
		board.solve();

		int[][] expecteds = { { 8, 5, 7, 9, 1, 2, 3, 4, 6 }, { 2, 9, 1, 3, 4, 6, 7, 5, 8 },
				{ 3, 4, 6, 7, 8, 5, 1, 9, 2 }, { 1, 2, 4, 5, 6, 7, 9, 8, 3 }, { 7, 6, 8, 1, 3, 9, 4, 2, 5 },
				{ 9, 3, 5, 8, 2, 4, 6, 7, 1 }, { 4, 1, 2, 6, 9, 8, 5, 3, 7 }, { 6, 7, 9, 2, 5, 3, 8, 1, 4 },
				{ 5, 8, 3, 4, 7, 1, 2, 6, 9 } };

		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_XWing3Board_CorrectResult() {
		Board board = new Board("res/methods/X-Wing3.txt");
		board.solve();

		int[][] expecteds = { { 6, 8, 4, 1, 3, 7, 2, 5, 9 }, { 1, 7, 9, 5, 6, 2, 8, 3, 4 },
				{ 3, 5, 2, 9, 8, 4, 1, 6, 7 }, { 8, 2, 7, 3, 1, 6, 9, 4, 5 }, { 4, 9, 3, 7, 5, 8, 6, 1, 2 },
				{ 5, 1, 6, 2, 4, 9, 3, 7, 8 }, { 7, 3, 5, 8, 9, 1, 4, 2, 6 }, { 9, 4, 1, 6, 2, 5, 7, 8, 3 },
				{ 2, 6, 8, 4, 7, 3, 5, 9, 1 } };

		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
