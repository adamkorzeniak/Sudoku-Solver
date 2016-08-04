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
		int[] expecteds = new int[6];
		int[] actuals = new int[6];

		expecteds[0] = 2;
		actuals[0] = board.getField(6, 1).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(6, 3).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(6, 4).getPossibleCount();
		expecteds[3] = 3;
		actuals[3] = board.getField(6, 5).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(6, 8).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(6, 9).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_NakedPairsBoard4_CorrectResult() {
		Board board = new Board("res/methods/NakedPairs4.txt");
		board.solve();
		int[] expecteds = new int[6];
		int[] actuals = new int[6];

		expecteds[0] = 3;
		actuals[0] = board.getField(2, 8).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(3, 8).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(4, 8).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(5, 8).getPossibleCount();
		expecteds[4] = 3;
		actuals[4] = board.getField(6, 8).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(8, 8).getPossibleCount();

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
