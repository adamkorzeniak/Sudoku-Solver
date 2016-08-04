package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverHiddenPairs {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class
	
	@Test
	public void SolveBoard_HiddenPairsBoard_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs.txt");
		board.solve();
		int[] expecteds = new int[5];
		int[] actuals = new int[5];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(3, 3).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(4, 3).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(6, 3).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(8, 3).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(9, 3).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_HiddenPairs2Board_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs2.txt");
		board.solve();
		int[] expecteds = new int[7];
		int[] actuals = new int[7];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(2, 5).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(3, 5).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(4, 5).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(5, 5).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(6, 5).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(8, 5).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(9, 5).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_HiddenPairs3Board_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs3.txt");
		board.solve();
		int[] expecteds = new int[7];
		int[] actuals = new int[7];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(5, 1).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(5, 3).getPossibleCount();
		expecteds[2] = 3;
		actuals[2] = board.getField(5, 4).getPossibleCount();
		expecteds[3] = 3;
		actuals[3] = board.getField(5, 6).getPossibleCount();
		expecteds[4] = 3;
		actuals[4] = board.getField(5, 7).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(5, 8).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(5, 9).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_HiddenPairs4Board_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs4.txt");
		board.solve();
		int[] expecteds = new int[8];
		int[] actuals = new int[8];
		
		expecteds[0] = 3;
		actuals[0] = board.getField(5, 1).getPossibleCount();
		expecteds[1] = 3;
		actuals[1] = board.getField(5, 2).getPossibleCount();
		expecteds[2] = 4;
		actuals[2] = board.getField(5, 3).getPossibleCount();
		expecteds[3] = 3;
		actuals[3] = board.getField(5, 4).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(5, 5).getPossibleCount();
		expecteds[5] = 3;
		actuals[5] = board.getField(5, 6).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(5, 8).getPossibleCount();
		expecteds[7] = 3;
		actuals[7] = board.getField(5, 9).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test 
	public void SolveBoard_HiddenPairs5Board_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs5.txt");
		board.solve();
		int[] expecteds = new int[7];
		int[] actuals = new int[7];
		
		expecteds[0] = 3;
		actuals[0] = board.getField(1, 5).getPossibleCount();
		expecteds[1] = 4;
		actuals[1] = board.getField(2, 5).getPossibleCount();
		expecteds[2] = 3;
		actuals[2] = board.getField(3, 5).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(4, 5).getPossibleCount();
		expecteds[4] = 3;
		actuals[4] = board.getField(6, 5).getPossibleCount();
		expecteds[5] = 3;
		actuals[5] = board.getField(8, 5).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(9, 5).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_HiddenPairs6Board_CorrectResult() {
		Board board = new Board("res/methods/HiddenPairs6.txt");
		board.solve();
		int[] expecteds = new int[9];
		int[] actuals = new int[9];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(1, 5).getPossibleCount();
		expecteds[1] = 2;
		actuals[1] = board.getField(2, 5).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(3, 5).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(4, 5).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(5, 5).getPossibleCount();
		expecteds[5] = 3;
		actuals[5] = board.getField(6, 5).getPossibleCount();
		expecteds[6] = 3;
		actuals[6] = board.getField(7, 5).getPossibleCount();
		expecteds[7] = 4;
		actuals[7] = board.getField(8, 5).getPossibleCount();
		expecteds[8] = 4;
		actuals[8] = board.getField(9, 5).getPossibleCount();

		assertArrayEquals(expecteds, actuals);
	}

}
