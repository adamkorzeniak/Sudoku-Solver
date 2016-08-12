package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.adkorzen.SudokuSolver.exceptions.IncorrectValueException;
import com.github.adkorzen.SudokuSolver.main.Board;
import com.github.adkorzen.SudokuSolver.main.Field;

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
		int actual = 0;

		for (int i = 0; i < size; i++) {
			actual += fields[i].length;
		}
		int expected = 81;
		assertEquals(expected, actual);
	}

	@Test
	public void SetAndGetFieldValue_FieldWithValue_CorrectlySet() {
		Field field = board.getField(3, 4);
		int actual = field.getValue();
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void SetAndGetFieldValue_FieldWithNoValue_ZeroValue() {
		Field field = board.getField(3, 1);
		int actual = field.getValue();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void SetAndGetResult_CorrectValues_CorrectlySet() {
		board.setResult(5, 7, 2);
		int actual = board.getResult()[6][4];
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test(expected = IncorrectValueException.class)
	public void SetResult_TooHighValue_RuntimeException() {
		board.setResult(5, 7, 11);
	}

	@Test(expected = IncorrectValueException.class)
	public void SetResult_TooLowValue_RuntimeException() {
		board.setResult(5, 7, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void SetResult_XCoorTooLow_RuntimeException() {
		board.setResult(0, 7, 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void SetResult_XCoorTooHigh_RuntimeException() {
		board.setResult(10, 7, 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void SetResult_YCoorTooLow_RuntimeException() {
		board.setResult(3, -1, 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void SetResult_YCoorTooHigh_RuntimeException() {
		board.setResult(3, 22, 3);
	}
}
