package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverXYWing {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class

	@Test
	public void SolveBoard_XYWingBoard_CorrectResult() {
		Board board = new Board("res/methods/XY-Wing.txt");
		board.solve();
		
		int[][] expecteds = {
				{2, 1, 3, 8, 5, 4, 9, 7, 6}, 
				{4, 5, 9, 1, 6, 7, 2, 3, 8}, 
				{8, 7, 6, 3, 9, 2, 5, 4, 1}, 
				{6, 8, 4, 5, 3, 1, 7, 9, 2}, 
				{7, 2, 5, 9, 4, 8, 6, 1, 3}, 
				{9, 3, 1, 2, 7, 6, 4, 8, 5}, 
				{1, 9, 2, 7, 8, 5, 3, 6, 4}, 
				{5, 6, 7, 4, 1, 3, 8, 2, 9}, 
				{3, 4, 8, 6, 2, 9, 1, 5, 7}};
		int[][] actuals = board.getResult();
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void SolveBoard_XYWing2Board_CorrectResult() {
		Board board = new Board("res/methods/XY-Wing2.txt");
		board.solve();
		
		int[][] expecteds = { {9, 3, 1, 8, 6, 4, 7, 5, 2}, 
				{4, 6, 2, 9, 7, 5, 8, 1, 3}, 
				{7, 8, 5, 2, 1, 3, 9, 6, 4}, 
				{2, 1, 8, 4, 5, 9, 6, 3, 7}, 
				{3, 5, 7, 6, 2, 8, 4, 9, 1}, 
				{6, 4, 9, 1, 3, 7, 5, 2, 8}, 
				{5, 2, 4, 7, 9, 1, 3, 8, 6}, 
				{1, 7, 3, 5, 8, 6, 2, 4, 9}, 
				{8, 9, 6, 3, 4, 2, 1, 7, 5} };
		int[][] actuals = board.getResult();
		
		assertArrayEquals(expecteds, actuals);
	}
	
}
