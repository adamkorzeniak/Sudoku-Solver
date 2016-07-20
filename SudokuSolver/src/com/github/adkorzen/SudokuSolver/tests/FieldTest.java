package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.adkorzen.SudokuSolver.Board;
import com.github.adkorzen.SudokuSolver.Field;
import com.github.adkorzen.SudokuSolver.exceptions.AmbiguousValueException;
import com.github.adkorzen.SudokuSolver.exceptions.NoPossibleValueException;

public class FieldTest {

	private Field field;

	@Before
	public void setUp() throws Exception {
		field = new Field(new Board("res/tests/SudokuTest.txt"), 3, 4);
	}

	@Test
	public void SetValueAndDecreaseCount_PossibleCount1_OK() {
		
		for (int i = 1; i < 9; i++) field.setImpossible(i);
		for (int i = 0; i < 8; i++) field.decreasePossibleCount();
		
		int expected = 1;
		int actual = field.getValue();
		
		assertEquals(expected, actual);
	}
	@Test (expected = AmbiguousValueException.class)
	public void SetValue_PossibleCountMoreThan1_RuntimeException() {
		
		for (int i = 1; i < 9; i++) field.setImpossible(i);
		for (int i = 0; i < 7; i++) field.decreasePossibleCount();
		field.setValue();
	}
	
	@Test (expected = NoPossibleValueException.class)
	public void SetValue_PossibleCounty0_RuntimeExceptio() {
		
		for (int i = 1; i < 9; i++) field.setImpossible(i);
		for (int i = 0; i < 9; i++) field.decreasePossibleCount();
		field.setValue();
	}

}
