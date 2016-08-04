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


		int[][] expecteds = {{9, 6, 2, 4, 5, 1, 7, 3, 8}, 
			{1, 4, 7, 3, 9, 8, 2, 6, 5}, 
			{5, 8, 3, 2, 7, 6, 4, 9, 1}, 
			{8, 1, 6, 7, 2, 4, 3, 5, 9}, 
			{2, 3, 9, 1, 6, 5, 8, 4, 7}, 
			{4, 7, 5, 9, 8, 3, 6, 1, 2}, 
			{6, 2, 1, 5, 3, 7, 9, 8, 4}, 
			{7, 5, 8, 6, 4, 9, 1, 2, 3}, 
			{3, 9, 4, 8, 1, 2, 5, 7, 6} };
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void SolveBoard_XWing2Board_CorrectResult() {
		Board board = new Board("res/methods/X-Wing2.txt");
		board.solve();

		int[][] expecteds = {
				{8, 5, 7, 9, 1, 2, 3, 4, 6}, 
				{2, 9, 1, 3, 4, 6, 7, 5, 8}, 
				{3, 4, 6, 7, 8, 5, 1, 9, 2}, 
				{1, 2, 4, 5, 6, 7, 9, 8, 3}, 
				{7, 6, 8, 1, 3, 9, 4, 2, 5}, 
				{9, 3, 5, 8, 2, 4, 6, 7, 1}, 
				{4, 1, 2, 6, 9, 8, 5, 3, 7}, 
				{6, 7, 9, 2, 5, 3, 8, 1, 4}, 
				{5, 8, 3, 4, 7, 1, 2, 6, 9} };
		
		int[][] actuals = board.getResult();

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
