package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverNakedPairs {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_NakedPairsBoard_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs.txt");
		board.solve();
		int expected = 6;
		int actual = board.getField(8, 9).getValue();

		assertEquals(expected, actual);
	}

	@Test
	public void SolveBoard_NakedPairsBoard2_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs2.txt");
		board.solve();
		int[][] expecteds = { { 6, 9, 4, 8, 1, 2, 7, 3, 5 }, { 7, 1, 2, 3, 5, 6, 9, 4, 8 },
				{ 3, 5, 8, 4, 9, 7, 1, 6, 2 }, { 1, 3, 6, 9, 7, 5, 8, 2, 4 }, { 2, 4, 5, 1, 8, 3, 6, 7, 9 },
				{ 8, 7, 9, 6, 2, 4, 5, 1, 3 }, { 4, 8, 3, 5, 6, 1, 2, 9, 7 }, { 5, 6, 7, 2, 4, 9, 3, 8, 1 },
				{ 9, 2, 1, 7, 3, 8, 4, 5, 6 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_NakedPairsBoard3_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs3.txt");
		board.solve();
		int[][] expecteds = { { 4, 8, 1, 3, 9, 7, 6, 5, 2 }, { 2, 6, 7, 1, 5, 8, 3, 9, 4 },
				{ 5, 9, 3, 6, 2, 4, 1, 8, 7 }, { 1, 7, 2, 8, 6, 3, 5, 4, 9 }, { 6, 4, 5, 9, 7, 1, 2, 3, 8 },
				{ 8, 3, 9, 2, 4, 5, 7, 1, 6 }, { 7, 5, 6, 4, 1, 9, 8, 2, 3 }, { 3, 1, 4, 7, 8, 2, 9, 6, 5 },
				{ 9, 2, 8, 5, 3, 6, 4, 7, 1 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_NakedPairsBoard4_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs4.txt");
		board.solve();
		int[][] expecteds = { { 5, 3, 8, 7, 4, 6, 9, 1, 2 }, { 4, 6, 9, 3, 1, 2, 8, 7, 5 },
				{ 2, 7, 1, 8, 9, 5, 3, 4, 6 }, { 3, 4, 7, 6, 8, 9, 2, 5, 1 }, { 9, 1, 5, 4, 2, 3, 7, 6, 8 },
				{ 8, 2, 6, 5, 7, 1, 4, 3, 9 }, { 6, 9, 2, 1, 3, 4, 5, 8, 7 }, { 7, 5, 4, 2, 6, 8, 1, 9, 3 },
				{ 1, 8, 3, 9, 5, 7, 6, 2, 4 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_NakedPairs5Board_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs5.txt");
		board.solve();
		int[][] expecteds = { { 6, 2, 4, 9, 3, 8, 7, 5, 1 }, { 7, 3, 9, 1, 6, 5, 4, 2, 8 },
				{ 8, 1, 5, 7, 2, 4, 6, 9, 3 }, { 4, 6, 2, 8, 1, 9, 3, 7, 5 }, { 3, 8, 7, 5, 4, 2, 9, 1, 6 },
				{ 5, 9, 1, 6, 7, 3, 8, 4, 2 }, { 9, 5, 6, 4, 8, 1, 2, 3, 7 }, { 1, 7, 3, 2, 9, 6, 5, 8, 4 },
				{ 2, 4, 8, 3, 5, 7, 1, 6, 9 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
