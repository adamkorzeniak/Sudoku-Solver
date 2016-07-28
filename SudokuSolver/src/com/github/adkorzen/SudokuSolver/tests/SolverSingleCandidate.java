package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverSingleCandidate {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class
	
	@Test
	public void SolveBoard_SingleCandidateBoard_CorrectResult() {
		Board board = new Board("res/methods/SingleCandidate.txt");
		board.solve();
		int[][] expecteds = { { 9, 8, 4, 1, 3, 6, 7, 2, 5 }, { 2, 3, 7, 8, 5, 4, 9, 1, 6 },
				{ 6, 5, 1, 2, 9, 7, 3, 4, 8 }, { 4, 1, 8, 3, 6, 5, 2, 9, 7 }, { 3, 6, 2, 7, 8, 9, 4, 5, 1 },
				{ 5, 7, 9, 4, 2, 1, 8, 6, 3 }, { 8, 9, 3, 6, 1, 2, 5, 7, 4 }, { 1, 4, 5, 9, 7, 3, 6, 8, 2 },
				{ 7, 2, 6, 5, 4, 8, 1, 3, 9 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_SingleCandidate2Board_CorrectResult() {
		Board board = new Board("res/methods/SingleCandidate2.txt");
		board.solve();
		int[][] expecteds = { { 9, 2, 6, 4, 3, 5, 8, 1, 7 }, { 8, 3, 5, 1, 6, 7, 9, 4, 2 },
				{ 4, 7, 1, 8, 2, 9, 3, 5, 6 }, { 1, 8, 2, 3, 7, 4, 6, 9, 5 }, { 3, 5, 9, 6, 8, 2, 1, 7, 4 },
				{ 6, 4, 7, 5, 9, 1, 2, 3, 8 }, { 7, 9, 3, 2, 4, 8, 5, 6, 1 }, { 2, 1, 4, 9, 5, 6, 7, 8, 3 },
				{ 5, 6, 8, 7, 1, 3, 4, 2, 9 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
