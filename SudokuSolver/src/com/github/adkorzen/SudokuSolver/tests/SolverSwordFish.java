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
		
		int[] expecteds = new int[11];
		int[] actuals = new int[11];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(2, 3).getPossibleCount();
		expecteds[1] = 3;
		actuals[1] = board.getField(2, 4).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(2, 5).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(2, 8).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(4, 2).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(4, 3).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(4, 5).getPossibleCount();
		expecteds[7] = 2;
		actuals[7] = board.getField(4, 8).getPossibleCount();
		expecteds[8] = 2;
		actuals[8] = board.getField(4, 9).getPossibleCount();
		expecteds[9] = 2;
		actuals[9] = board.getField(7, 5).getPossibleCount();
		expecteds[10] = 2;
		actuals[10] = board.getField(7, 8).getPossibleCount();
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_SwordFish2Board_CorrectResult() {
		Board board = new Board("res/methods/Swordfish2.txt");
		board.solve();
		
		int[] expecteds = new int[12];
		int[] actuals = new int[12];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(2, 3).getPossibleCount();
		expecteds[1] = 4;//
		actuals[1] = board.getField(2, 4).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(2, 5).getPossibleCount();
		expecteds[3] = 3;//
		actuals[3] = board.getField(2, 6).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(2, 8).getPossibleCount();
		expecteds[5] = 3;//
		actuals[5] = board.getField(4, 1).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(4, 3).getPossibleCount();
		expecteds[7] = 2;
		actuals[7] = board.getField(4, 6).getPossibleCount();
		expecteds[8] = 2;
		actuals[8] = board.getField(4, 8).getPossibleCount();
		expecteds[9] = 3;
		actuals[9] = board.getField(4, 9).getPossibleCount();
		expecteds[10] = 2;
		actuals[10] = board.getField(7, 3).getPossibleCount();
		expecteds[11] = 2;
		actuals[11] = board.getField(7, 5).getPossibleCount();
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_SwordFish3Board_CorrectResult() {
		Board board = new Board("res/methods/Swordfish3.txt");
		board.solve();
		
		int[] expecteds = new int[11];
		int[] actuals = new int[11];
		
		expecteds[0] = 2;
		actuals[0] = board.getField(3, 2).getPossibleCount();
		expecteds[1] = 3;
		actuals[1] = board.getField(4, 2).getPossibleCount();
		expecteds[2] = 2;
		actuals[2] = board.getField(5, 2).getPossibleCount();
		expecteds[3] = 2;
		actuals[3] = board.getField(8, 2).getPossibleCount();
		expecteds[4] = 2;
		actuals[4] = board.getField(2, 4).getPossibleCount();
		expecteds[5] = 2;
		actuals[5] = board.getField(3, 4).getPossibleCount();
		expecteds[6] = 2;
		actuals[6] = board.getField(5, 4).getPossibleCount();
		expecteds[7] = 2;
		actuals[7] = board.getField(8, 4).getPossibleCount();
		expecteds[8] = 2;
		actuals[8] = board.getField(9, 4).getPossibleCount();
		expecteds[9] = 2;
		actuals[9] = board.getField(5, 7).getPossibleCount();
		expecteds[10] = 2;
		actuals[10] = board.getField(8, 7).getPossibleCount();
		
		assertArrayEquals(expecteds, actuals);
	}
}
