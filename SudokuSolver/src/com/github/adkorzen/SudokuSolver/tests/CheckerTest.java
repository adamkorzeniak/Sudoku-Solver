package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.Main.Board;

public class CheckerTest {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_SinglePositionBoard_CorrectResult() {
		Board board = new Board("res/methods/SinglePosition.txt");
		board.solve();
		int[][] expecteds = { { 9, 4, 6, 1, 3, 5, 7, 2, 8 }, { 7, 3, 5, 6, 8, 2, 9, 4, 1 },
				{ 2, 8, 1, 9, 7, 4, 6, 3, 5 }, { 1, 2, 4, 3, 5, 9, 8, 7, 6 }, { 3, 7, 9, 8, 4, 6, 1, 5, 2 },
				{ 5, 6, 8, 2, 1, 7, 3, 9, 4 }, { 8, 1, 2, 4, 9, 3, 5, 6, 7 }, { 6, 5, 3, 7, 2, 1, 4, 8, 9 },
				{ 4, 9, 7, 5, 6, 8, 2, 1, 3 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_SinglePosition2Board_CorrectResult() {
		Board board = new Board("res/methods/SinglePosition2.txt");
		board.solve();
		int[][] expecteds = { { 9, 7, 2, 1, 3, 5, 8, 6, 4 }, { 4, 3, 8, 2, 7, 6, 1, 5, 9 },
				{ 6, 5, 1, 4, 9, 8, 2, 3, 7 }, { 1, 6, 9, 3, 8, 2, 4, 7, 5 }, { 3, 8, 7, 5, 4, 1, 9, 2, 6 },
				{ 5, 2, 4, 9, 6, 7, 3, 1, 8 }, { 7, 9, 6, 8, 1, 3, 5, 4, 2 }, { 2, 4, 3, 7, 5, 9, 6, 8, 1 },
				{ 8, 1, 5, 6, 2, 4, 7, 9, 3 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

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
	public void SolveBoard_MultipleLinesBoard_CorrectResult() {
		Board board = new Board("res/methods/MultipleLines.txt");
		board.solve();
		int[][] expecteds = { { 8, 4, 9, 5, 3, 2, 6, 1, 7 }, { 5, 3, 6, 7, 1, 4, 2, 8, 9 },
				{ 1, 2, 7, 8, 6, 9, 4, 3, 5 }, { 3, 9, 5, 4, 7, 1, 8, 2, 6 }, { 7, 1, 4, 2, 8, 6, 5, 9, 3 },
				{ 2, 6, 8, 3, 9, 5, 1, 7, 4 }, { 6, 8, 1, 9, 5, 3, 7, 4, 2 }, { 9, 7, 2, 6, 4, 8, 3, 5, 1 },
				{ 4, 5, 3, 1, 2, 7, 9, 6, 8 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_MultipleLines2Board_CorrectResult() {
		Board board = new Board("res/methods/MultipleLines2.txt");
		board.solve();
		int[][] expecteds = { { 8, 5, 1, 3, 7, 2, 6, 9, 4 }, { 4, 3, 2, 9, 1, 6, 8, 7, 5 },
				{ 9, 6, 7, 5, 4, 8, 1, 2, 3 }, { 5, 7, 8, 4, 2, 3, 9, 6, 1 }, { 3, 1, 6, 7, 8, 9, 5, 4, 2 },
				{ 2, 4, 9, 1, 6, 5, 3, 8, 7 }, { 6, 2, 4, 8, 5, 1, 7, 3, 9 }, { 1, 8, 3, 2, 9, 7, 4, 5, 6 },
				{ 7, 9, 5, 6, 3, 4, 2, 1, 8 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

}
