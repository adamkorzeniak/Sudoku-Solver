package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.adkorzen.SudokuSolver.Board;
import com.github.adkorzen.SudokuSolver.Field;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() {
		board = new Board("res/tests/SudokuTest.txt");
	}

	@Test
	public void BoardConstructor_PassCorrectArray_SetResults() {
		int[][] actual = board.getResult();
		int[][] expected = { { 0, 0, 0, 0, 2, 0, 0, 4, 0 }, { 0, 0, 2, 0, 0, 0, 0, 5, 0 },
				{ 4, 1, 8, 0, 0, 0, 0, 0, 0 }, { 0, 9, 5, 0, 0, 0, 0, 6, 1 }, { 0, 0, 4, 0, 0, 0, 0, 0, 2 },
				{ 6, 0, 0, 0, 0, 0, 0, 0, 9 }, { 8, 0, 0, 0, 4, 5, 9, 0, 7 }, { 2, 0, 0, 0, 7, 8, 0, 0, 0 },
				{ 0, 4, 6, 0, 0, 2, 0, 8, 0 } };

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void BoardConstructor_PassCorrectArray_SetUpFields() {
		Field[][] fields = board.getFields();
		int size = fields.length;
		int actual  = 0;
		
		for (int i = 0; i < size; i++) {
			actual += fields[i].length;
		}
		int expected = 81;
		assertEquals(expected, actual);
	}
}
