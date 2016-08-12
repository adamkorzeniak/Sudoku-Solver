package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverSwordFish {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_SwordFishBoard_CorrectResult() {
		Board board = new Board("res/methods/Swordfish.txt");
		board.solve();

		int[][] expecteds = { { 1, 9, 5, 3, 6, 7, 2, 4, 8 }, { 2, 7, 8, 1, 5, 4, 3, 6, 9 },
				{ 3, 4, 6, 2, 9, 8, 1, 5, 7 }, { 6, 2, 3, 7, 8, 1, 5, 9, 4 }, { 7, 1, 9, 4, 2, 5, 8, 3, 6 },
				{ 5, 8, 4, 9, 3, 6, 7, 1, 2 }, { 8, 3, 2, 5, 4, 9, 6, 7, 1 }, { 9, 6, 7, 8, 1, 3, 4, 2, 5 },
				{ 4, 5, 1, 6, 7, 2, 9, 8, 3 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_SwordFish2Board_CorrectResult() {
		Board board = new Board("res/methods/Swordfish2.txt");
		board.solve();

		int[][] expecteds = { { 5, 6, 3, 4, 7, 2, 9, 8, 1 }, { 1, 8, 4, 9, 5, 3, 2, 6, 7 },
				{ 9, 2, 7, 1, 6, 8, 5, 4, 3 }, { 2, 7, 1, 6, 9, 5, 4, 3, 8 }, { 4, 5, 6, 8, 3, 7, 1, 9, 2 },
				{ 3, 9, 8, 2, 1, 4, 6, 7, 5 }, { 6, 4, 5, 3, 8, 1, 7, 2, 9 }, { 8, 1, 9, 7, 2, 6, 3, 5, 4 },
				{ 7, 3, 2, 5, 4, 9, 8, 1, 6 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_SwordFish3Board_CorrectResult() {
		Board board = new Board("res/methods/Swordfish3.txt");
		board.solve();

		int[][] expecteds = { { 1, 2, 3, 6, 7, 5, 8, 9, 4 }, { 9, 7, 4, 2, 1, 8, 3, 6, 5 },
				{ 5, 8, 6, 3, 9, 4, 2, 7, 1 }, { 3, 1, 2, 7, 4, 9, 5, 8, 6 }, { 6, 5, 9, 8, 2, 3, 4, 1, 7 },
				{ 7, 4, 8, 1, 5, 6, 9, 3, 2 }, { 2, 3, 1, 5, 8, 7, 6, 4, 9 }, { 4, 6, 5, 9, 3, 1, 7, 2, 8 },
				{ 8, 9, 7, 4, 6, 2, 1, 5, 3 } };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}
}
