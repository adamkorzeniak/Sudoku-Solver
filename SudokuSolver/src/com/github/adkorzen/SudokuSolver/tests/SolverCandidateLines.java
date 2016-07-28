package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverCandidateLines {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class
	
	@Test
	public void SolveBoard_CandidateLinesBoard_CorrectResult() {
		Board board = new Board("res/methods/CandidateLines.txt");
		board.solve();
		System.out.println(board.getResult()[0][0]);
		int[][] expecteds = { { 2, 8, 1, 9, 5, 7, 4, 6, 3 }, { 4, 3, 5, 8, 2, 6, 9, 7, 1 },
				{ 7, 6, 9, 1, 3, 4, 8, 2, 5 }, { 8, 4, 7, 2, 6, 1, 3, 5, 9 }, { 3, 1, 2, 4, 9, 5, 7, 8, 6 },
				{ 9, 5, 6, 3, 7, 8, 2, 1, 4 }, { 1, 2, 8, 6, 4, 9, 5, 3, 7 }, { 5, 9, 3, 7, 1, 2, 6, 4, 8 },
				{ 6, 7, 4, 5, 8, 3, 1, 9, 2 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_CandidateLines2Board_CorrectResult() {
		Board board = new Board("res/methods/CandidateLines2.txt");
		board.solve();
		System.out.println(board.getResult()[0][0]);
		int[][] expecteds = { { 2, 4, 7, 8, 3, 9, 1, 5, 6 }, { 8, 3, 6, 4, 1, 5, 2, 9, 7 },
				{ 1, 5, 9, 7, 2, 6, 8, 3, 4 }, { 9, 8, 1, 2, 4, 3, 6, 7, 5 }, { 5, 2, 3, 6, 9, 7, 4, 1, 8 },
				{ 7, 6, 4, 1, 5, 8, 9, 2, 3 }, { 4, 9, 8, 3, 7, 2, 5, 6, 1 }, { 6, 7, 2, 5, 8, 1, 3, 4, 9 },
				{ 3, 1, 5, 9, 6, 4, 7, 8, 2 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
