package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.Main.Board;

public class CheckerTest {

	private Board board;

	@Test
	public void SolveBoard_BoardProvided_CorrectResult() {
		board = new Board("res/tests/SudokuTest.txt");
		board.solve();
		int[][] expecteds = { { 5, 7, 3, 8, 2, 9, 1, 4, 6 }, { 9, 6, 2, 4, 3, 1, 7, 5, 6 }, { 3, 9, 5, 2, 8, 7, 4, 6, 1 },
				{ 4, 1, 8, 7, 5, 6, 2, 9, 3 }, { 1, 8, 4, 9, 6, 3, 5, 7, 2 }, { 6, 2, 7, 5, 1, 4, 8, 3, 9 },
				{ 8, 3, 1, 6, 4, 5, 9, 2, 7 }, { 2, 5, 9, 3, 7, 8, 6, 1, 4 }, { 7, 4, 6, 1, 9, 2, 3, 8, 5 } };
		int[][] actuals = board.getResult();
		
		assertArrayEquals(expecteds, actuals);
	}

}
