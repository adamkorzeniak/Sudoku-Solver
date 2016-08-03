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


		int expected= 8;
		int actual = board.getField(9, 1).getValue();

		assertEquals(expected, actual);
	}

	@Test
	public void SolveBoard_XWing2Board_CorrectResult() {
		Board board = new Board("res/methods/X-Wing2.txt");
		board.solve();

		int[] expecteds = new int[10];
		int[] actuals = new int[10];

		expecteds[0] = 2;
		actuals[0] = board.getField(6, 4).getPossibleCount();
		expecteds[1] = 4;
		actuals[1] = board.getField(6, 5).getPossibleCount();
		expecteds[2] = 3;
		actuals[2] = board.getField(6, 6).getPossibleCount();
		expecteds[3] = 3;
		actuals[3] = board.getField(6, 7).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(6, 8).getPossibleCount();
		expecteds[5] = 3;
		actuals[5] = board.getField(6, 9).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(8, 1).getPossibleCount();
		expecteds[7] = 2;
		actuals[7] = board.getField(8, 4).getPossibleCount();
		expecteds[8] = 2;
		actuals[8] = board.getField(8, 6).getPossibleCount();
		expecteds[9] = 2;
		actuals[9] = board.getField(8, 7).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_XWing3Board_CorrectResult() {
		Board board = new Board("res/methods/X-Wing3.txt");
		board.solve();

		int[] expecteds = new int[12];
		int[] actuals = new int[12];

		expecteds[0] = 2;
		actuals[0] = board.getField(3, 3).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(5, 3).getPossibleCount();
		expecteds[2] = 0;
		actuals[2] = board.getField(6, 3).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(9, 3).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(2, 9).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(3, 9).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(4, 9).getPossibleCount();
		expecteds[7] = 2;
		actuals[7] = board.getField(5, 9).getPossibleCount();
		expecteds[8] = 3;
		actuals[8] = board.getField(7, 9).getPossibleCount();
		expecteds[9] = 3;
		actuals[9] = board.getField(8, 9).getPossibleCount();
		expecteds[10] = 2;
		actuals[10] = board.getField(9, 9).getPossibleCount();
		expecteds[11] = 4;
		actuals[11] = board.getField(6, 3).getValue();

		assertArrayEquals(expecteds, actuals);
	}

}
