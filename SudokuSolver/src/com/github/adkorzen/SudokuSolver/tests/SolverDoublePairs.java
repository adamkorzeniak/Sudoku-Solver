package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverDoublePairs {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_DoublePairsBoard_CorrectResult() {
		Board board = new Board("res/methods/DoublePairs.txt");
		board.solve();
		int[][] expecteds = { { 9, 3, 4, 1, 6, 2, 7, 5, 8 }, { 1, 5, 6, 8, 7, 4, 9, 2, 3 },
				{ 7, 2, 8, 9, 3, 5, 1, 4, 6 }, { 8, 9, 2, 5, 4, 6, 3, 1, 7 }, { 6, 4, 3, 2, 1, 7, 8, 9, 5 },
				{ 5, 1, 7, 3, 9, 8, 4, 6, 2 }, { 3, 6, 5, 4, 8, 1, 2, 7, 9 }, { 4, 7, 9, 6, 2, 3, 5, 8, 1 },
				{ 2, 8, 1, 7, 5, 9, 6, 3, 4 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_DoublePairs2Board_CorrectResult() {
		Board board = new Board("res/methods/DoublePairs2.txt");
		board.solve();
		int[][] expecteds = { { 9, 1, 7, 8, 6, 5, 3, 4, 2 }, { 3, 5, 2, 9, 4, 1, 6, 7, 8 },
				{ 4, 6, 8, 2, 3, 7, 5, 9, 1 }, { 1, 8, 9, 5, 2, 3, 4, 6, 7 }, { 6, 7, 3, 4, 1, 9, 8, 2, 5 },
				{ 2, 4, 5, 6, 7, 8, 1, 3, 9 }, { 7, 9, 1, 3, 8, 4, 2, 5, 6 }, { 5, 2, 4, 1, 9, 6, 7, 8, 3 },
				{ 8, 3, 6, 7, 5, 2, 9, 1, 4 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
