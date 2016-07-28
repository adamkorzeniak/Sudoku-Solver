package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.adkorzen.SudokuSolver.main.Board;

public class SolverDoublePairs {

	// In order for all tests to work comment out System.exit
	// from method decreaseUnsolvedAmount() from Board class
	
	@Test
	public void SolveBoard_DoublePairsBoard_CorrectResult() {
		Board board = new Board("res/methods/DoublePairs.txt");
		board.solve();
		int expected = 7;
		int actual = board.getField(4, 9).getValue();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void SolveBoard_DoublePairs2Board_CorrectResult() {
		Board board = new Board("res/methods/DoublePairs2.txt");
		board.solve();
		int expected = 7;
		int actual = board.getField(9, 4).getValue();
				
		assertEquals(expected, actual);
	}

}
