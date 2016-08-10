package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverForcingChains {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class
	
	@Test
	public void SolveBoard_ForcingChainsBoard_CorrectResult() {
		Board board = new Board("res/methods/ForcingChains.txt");
		board.solve();
		int[][] expecteds = {
				{8, 7, 1, 5, 6, 2, 4, 3, 9}, 
				{6, 3, 9, 8, 4, 1, 2, 5, 7}, 
				{4, 2, 5, 7, 3, 9, 6, 8, 1}, 
				{5, 9, 4, 3, 2, 7, 1, 6, 8}, 
				{2, 1, 8, 9, 5, 6, 7, 4, 3}, 
				{7, 6, 3, 4, 1, 8, 9, 2, 5}, 
				{9, 4, 6, 1, 8, 5, 3, 7, 2}, 
				{3, 8, 7, 2, 9, 4, 5, 1, 6}, 
				{1, 5, 2, 6, 7, 3, 8, 9, 4}};
		int[][] actuals = board.getResult();

		assertArrayEquals(expecteds, actuals);
	}


}
