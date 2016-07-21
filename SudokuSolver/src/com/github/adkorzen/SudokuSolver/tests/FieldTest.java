package com.github.adkorzen.SudokuSolver.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.adkorzen.SudokuSolver.Main.Board;
import com.github.adkorzen.SudokuSolver.Main.Field;

public class FieldTest {

	private Field field;

	@Before
	public void setUp() throws Exception {
		field = new Field(new Board("res/tests/SudokuTest.txt"), 3, 4);
	}

	@Test
	public void GetValueAndDecreaseCount_PossibleCount1_OK() {
		for (int i = 2; i < 10; i++) {
			field.setImpossibleValue(i);
		}
		int expected = 1;
		int actual = field.getValue();
		
		assertEquals(expected, actual);
	}

//	@Test(expected = AmbiguousValueException.class)
//	public void SetValue_PossibleCountMoreThan1_RuntimeException() {
//
//		for (int i = 1; i < 9; i++) {
//			field.setImpossibleValue(i);
//		}
//		for (int i = 0; i < 7; i++) {
//			field.decreasePossibleCount();
//		}
//		field.setValue();
//	}
//
//	@Test(expected = NoPossibleValueException.class)
//	public void SetValue_PossibleCounty0_RuntimeExceptio() {
//		for (int i = 1; i < 9; i++) {
//			field.setImpossibleValue(i);
//		}
//		for (int i = 0; i < 9; i++) {
//			field.decreasePossibleCount();
//		}
//		field.setValue();
//	}
	
	@Test
	public void FieldConstructor_SetAllValuesPossible_OK() {
		boolean[] expecteds = {true, true, true, true, true, true, true, true, true};
		boolean[] actuals = new boolean[9];
		for (int i = 0; i < 9; i++) {
			actuals[i] = field.isPossible(i + 1);
		}
		assertArrayEquals(expecteds, actuals);
	}

}
